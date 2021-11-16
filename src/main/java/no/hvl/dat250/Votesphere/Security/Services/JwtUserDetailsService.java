
package no.hvl.dat250.Votesphere.Security.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import no.hvl.dat250.Votesphere.DTO.PollUserDTO;
import no.hvl.dat250.Votesphere.DTO.PollUserService;

import java.util.ArrayList;

import javax.transaction.Transactional;


@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    PollUserService pollUserService;

    

    @Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		PollUserDTO pollUser = pollUserService.getPollUser(username);
        if(pollUser == null) throw new UsernameNotFoundException("User Not Found with username: " + username);

		return JwtUserImpl.build(pollUser);
	}
}
