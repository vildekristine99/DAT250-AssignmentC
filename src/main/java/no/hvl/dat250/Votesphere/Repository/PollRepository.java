package no.hvl.dat250.Votesphere.Repository;

import org.springframework.data.repository.CrudRepository;
import no.hvl.dat250.Votesphere.Entities.Poll;

public interface PollRepository extends CrudRepository<Poll, Long> {
    Poll findByPollId(Long id);

    //boolean existsByPollId(Long id);

    void deletePollByPollId(Long id);

    //List<Poll> findAllPoll();
}