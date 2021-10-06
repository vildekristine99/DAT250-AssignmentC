package no.hvl.dat250.Votesphere.RestAPI;

import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import no.hvl.dat250.Votesphere.DAO.EntityDAO;
import no.hvl.dat250.Votesphere.Entities.Poll;
import no.hvl.dat250.Votesphere.Entities.Vote;
import org.springframework.web.bind.annotation.*;

@RestController
public class PollController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private EntityDAO entityDAO = new EntityDAO();

    @GetMapping("/polls")
    public List<Poll> allPolls() {
        return entityDAO.findAllPolls();
    }

    @GetMapping("/poll/{id}")
    public Poll poll(@PathVariable int id) {
        return entityDAO.retrievePoll(id);
    }

    @PostMapping("/poll")
    public void newPoll(@RequestBody Poll newPoll) {
        entityDAO.addPolldb(newPoll);
    }

    @GetMapping("/poll/{id}/pollresult") // kanskje noe / id her?
    public Set<Vote> voteResult(@RequestParam int id) {
        return entityDAO.retrievePoll(id).getVotes();
    }

    @PostMapping("/poll/{id}")
    public void newVote(@RequestBody Vote Vote, @RequestParam int pollId) {
        entityDAO.addVotedb2(Vote, pollId);
    }

    @DeleteMapping("/poll/{id}")
    public void removePoll(@PathVariable int pollId) {
        entityDAO.removePoll(pollId);
    }
}