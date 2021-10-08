package no.hvl.dat250.Votesphere.RestAPI;

import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import no.hvl.dat250.Votesphere.DAO.EntityDAO;
import no.hvl.dat250.Votesphere.DTO.PollDTO;
import no.hvl.dat250.Votesphere.Entities.Poll;
import no.hvl.dat250.Votesphere.Entities.Vote;
import no.hvl.dat250.Votesphere.Repository.PollRepository;
import no.hvl.dat250.Votesphere.Repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import no.hvl.dat250.Votesphere.DTO.MapService;

@RestController
public class PollController {

    @Autowired
    private PollRepository pollRepository;
    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private MapService mapService;

    @GetMapping("/polls")
    @ResponseBody
    public List<PollDTO> getAllPolls() {
        List<PollDTO> polls = mapService.getAllPolls();
        return polls;
    }

    @PostMapping("/poll")
    public void newPoll(@RequestBody Poll newPoll) {
        pollRepository.save(newPoll);
    }
/*
    @GetMapping("/poll/{id}")
    public Poll poll(@PathVariable Long id) {
        return pollRepository.findByPollId(id);
    }*/

    @GetMapping("/polls/{id}")
    @ResponseBody
    public PollDTO pollById(@PathVariable Long id) {
        return mapService.getPollbyId(id);
    }

    @GetMapping("/poll/{id}/pollresult") // kanskje noe / id her?
    public Set<Vote> voteResult(@PathVariable Long id) {
        return pollRepository.findByPollId(id).getVotes();
    }

    @PostMapping("/polls/{id}")
    public void newVote(@RequestBody Vote vote, @PathVariable Long id) {
        Poll poll = pollRepository.findByPollId(id);
        poll.addVote(vote);
        voteRepository.save(vote);
        pollRepository.save(poll);
    }

    @DeleteMapping("/poll/{id}")
    public void removePoll(@PathVariable Long id) {
        pollRepository.deletePollByPollId(id);
    }
}