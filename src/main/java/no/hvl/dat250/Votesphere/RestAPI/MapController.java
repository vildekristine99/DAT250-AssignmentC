package no.hvl.dat250.Votesphere.RestAPI;

import no.hvl.dat250.Votesphere.DTO.MapService;
import no.hvl.dat250.Votesphere.DTO.PollUserDTO;
import no.hvl.dat250.Votesphere.DTO.PollDTO;
import no.hvl.dat250.Votesphere.Entities.Poll;
import no.hvl.dat250.Votesphere.Repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import no.hvl.dat250.Votesphere.Entities.PollUser;
import no.hvl.dat250.Votesphere.Repository.PollUserRepository;
import java.util.List;

@RestController
public class MapController {

    @Autowired
    private MapService mapService;

    @Autowired
    private PollUserRepository pollUserRepository;

    @Autowired
    private PollRepository pollRepository;

    @GetMapping("/users")
    @ResponseBody
    public List<PollUserDTO> getAllUsers() {
        List<PollUserDTO> pollUsers = mapService.getAllPollUsers();
        return pollUsers;
    }

    @PostMapping("/register")
    public void newPollUser(@RequestBody PollUser newUser) {
        pollUserRepository.save(newUser);
    }

    @GetMapping("/polls")
    public List<PollDTO> getAllPolls() {
        List<PollDTO> polls = mapService.getAllPolls();
        return polls;
    }

    @PostMapping("/poll")
    public void newPoll(@RequestBody Poll newPoll) {
        pollRepository.save(newPoll);
    }

}
