package no.hvl.dat250.Votesphere.RestAPI;

import no.hvl.dat250.Votesphere.Entities.Poll;
import no.hvl.dat250.Votesphere.Entities.PollUser;
import no.hvl.dat250.Votesphere.Repository.PollUserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private PollUserRepository pollUserRepository;

    @PostMapping("/register")
    public void newPollUser(@RequestBody PollUser newUser) {
        pollUserRepository.save(newUser);
    }
}
