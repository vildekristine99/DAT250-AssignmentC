package no.hvl.dat250.Votesphere.RestAPI;

import no.hvl.dat250.Votesphere.DTO.MapService;
import no.hvl.dat250.Votesphere.DTO.PollUserDTO;
import no.hvl.dat250.Votesphere.Entities.Poll;
import no.hvl.dat250.Votesphere.Entities.PollUser;
import no.hvl.dat250.Votesphere.Repository.PollRepository;
import no.hvl.dat250.Votesphere.Repository.PollUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private MapService mapService;

    @Autowired
    private PollUserRepository pollUserRepository;

    @GetMapping("/users")
    @ResponseBody
    public List<PollUserDTO> getAllUsers() {
        List<PollUserDTO> pollUsers = mapService.getAllPollUsers();
        return pollUsers;
    }

    @GetMapping("/users/{id}")
    @ResponseBody
    public PollUserDTO getUserById(@PathVariable long id) {
        return mapService.getPollUserById(id);
    }

    @PostMapping("/register")
    public void newPollUser(@RequestBody PollUser newUser) {
        pollUserRepository.save(newUser);
    }
}
