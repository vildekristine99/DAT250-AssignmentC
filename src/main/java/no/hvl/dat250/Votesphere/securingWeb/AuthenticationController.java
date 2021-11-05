package no.hvl.dat250.Votesphere.securingWeb;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins={ "http://localhost:3000", "http://localhost:4200" })
@RestController
public class AuthenticationController {

    @GetMapping(path = "/basicauth")
    public AuthenticationBean authenticate() {
        //throw new RuntimeException("Some Error has Happened! Contact Support at ***-***");
        return new AuthenticationBean("You are authenticated");
    }   
}