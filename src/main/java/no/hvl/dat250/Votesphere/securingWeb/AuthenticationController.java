package no.hvl.dat250.Votesphere.securingWeb;


import javax.validation.Valid;
import no.hvl.dat250.Votesphere.DTO.PollUserService;
import no.hvl.dat250.Votesphere.Entities.PollUser;
import no.hvl.dat250.Votesphere.response.JwtResponse;
import no.hvl.dat250.Votesphere.securingWeb.JwtUserDetails;
import org.apache.derby.impl.sql.execute.JarUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import no.hvl.dat250.Votesphere.response.JwtRequest;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private JwtUserDetails jwtUserDetails;

    @Autowired
    private JwtTokenUtil jwtUtil;

    @Autowired
    PollUserService pollUserService;

    @PostMapping(value = "/signin")
    public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            String username = jwtRequest.getUsername();
            String password = jwtRequest.getPassword();
            String hashedPassword = passwordEncoder.encode(password);
            System.out.println("Password: " + password + "\n Hashed password: " + hashedPassword);
            System.out.println(jwtRequest.getUsername());
            System.out.println(jwtRequest.getPassword());
            //authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, hashedPassword));

            if (passwordEncoder.matches(password, jwtUserDetails.loadUserByUsername(username).getPassword())){
                System.out.println("Password matches");
            } else throw new BadCredentialsException("Username and password don't match");
        } catch (Exception e) {
            System.out.println(e);
            throw new Exception("Bad credentials", e);
        }
        final UserDetails userDetails = jwtUserDetails.loadUserByUsername(jwtRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        System.out.println(jwt);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<PollUser> SignUp(@RequestBody PollUser newPollUser) {
        try {
            PollUser pollUser = pollUserService.addPollUser(newPollUser);
            return new ResponseEntity<>(pollUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}