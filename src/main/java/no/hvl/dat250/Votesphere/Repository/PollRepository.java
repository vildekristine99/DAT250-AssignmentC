package no.hvl.dat250.Votesphere.Repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import no.hvl.dat250.Votesphere.Entities.Poll;

public interface PollRepository extends CrudRepository<Poll, Integer> {
    Poll findByPollId(int id);

    //boolean existsByPollId(int id);

    void deletePollByPollId(int id);

    List<Poll> findAllPoll();
}