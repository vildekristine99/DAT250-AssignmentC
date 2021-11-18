package no.hvl.dat250.Votesphere.RestAPI;

import java.util.List;
import java.util.Set;
import no.hvl.dat250.Votesphere.DTO.PollDTO;
import no.hvl.dat250.Votesphere.Entities.Poll;
import no.hvl.dat250.Votesphere.Entities.Vote;
import no.hvl.dat250.Votesphere.Repository.PollRepository;
import no.hvl.dat250.Votesphere.Repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import no.hvl.dat250.Votesphere.DTO.MapService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class PollController {

    @Autowired
    private PollRepository pollRepository;
    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private MapService mapService;

    @GetMapping("/polls")
    @ResponseBody
    public ResponseEntity<List<PollDTO>> getAllPolls() {

        try {
            List<PollDTO> polls = mapService.getAllPolls();
            if (polls.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(polls, HttpStatus.OK);

        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/poll")
    public ResponseEntity<Poll> newPoll(@RequestBody Poll newPoll) {
        try{
            Poll poll = pollRepository.save(newPoll);
            return new ResponseEntity<>(poll, HttpStatus.CREATED);

        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/polls/{id}")
    @ResponseBody
    public ResponseEntity<PollDTO> pollById(@PathVariable Long id) {
        System.out.println(id);
        PollDTO pollDTO = mapService.getPollbyId(id);

        if (pollDTO != null) {
            return new ResponseEntity<>(pollDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Vet ikke hvordan vi skal gjøre dette
    @GetMapping("/pollresult/{id}/") // kanskje noe / id her?
    public ResponseEntity<Set<Vote>> voteResult(@PathVariable Long id) {

        try {
            Set<Vote> votes = pollRepository.findByPollId(id).getVotes();

            if (votes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(votes, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/vote")
    public ResponseEntity<Vote> newVote(@RequestBody Vote vote) {

        try {
            Vote savedVote = voteRepository.save(vote);
            return new ResponseEntity<>(savedVote, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/polls/{id}")
    public ResponseEntity<HttpStatus> removePoll(@PathVariable Long id) {
        try {
            pollRepository.deletePollByPollId(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}