
package no.hvl.dat250.Votesphere.securingWeb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import no.hvl.dat250.Votesphere.DTO.PollUserDTO;
import no.hvl.dat250.Votesphere.DTO.PollUserService;

import java.util.ArrayList;


@Service
public class JwtUserDetails implements UserDetailsService {
    @Autowired
    PollUserService pollUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        PollUserDTO pollUserDTO = pollUserService.getPollUser(username);
        if(pollUserDTO != null) {
            
            String password = pollUserDTO.getPassword();
            System.out.println(pollUserDTO.getUsername());

            return new User(username, password, new ArrayList<>());
        }
        throw new UsernameNotFoundException("Invalid username");
    }
}
