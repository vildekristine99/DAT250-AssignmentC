package no.hvl.dat250.Votesphere.RestAPI;

import no.hvl.dat250.Votesphere.Entities.Poll;
import no.hvl.dat250.Votesphere.Entities.PollUser;
import no.hvl.dat250.Votesphere.Repository.PollUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
public class UserController {
/*
    private PollUserRepository pollUserRepository;

    @PostMapping("/register")
    public void newPollUser(@RequestBody PollUser newUser) {
        pollUserRepository.save(newUser);
    }

    @GetMapping("/users")
    public List<PollUser> getAllUsers(){
        return (List<PollUser>) pollUserRepository.findAll();
    }*/
}
