package no.hvl.dat250.Votesphere.DTO;

import org.springframework.stereotype.Service;
import no.hvl.dat250.Votesphere.Entities.Poll;
import no.hvl.dat250.Votesphere.Repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PollService {
    @Autowired
    private PollRepository pollRepository;

  

    public Poll addPoll(Poll poll) {

        //PollUser pollUser = pollUserService.getUserById(poll.getPollUser().getId()).get();

        return pollRepository.save(poll);
    }
    
    public void deletePoll(long id) {
        pollRepository.deleteById(id);
    }

    public Poll getPollById(long id) {
        
        if (pollRepository.findById(id).isPresent()) {
            Poll poll = pollRepository.findByPollId(id);
            return poll;
        } else {
            return null;
        }
    }
    
}