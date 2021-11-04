package no.hvl.dat250.Votesphere.Repository;
import org.springframework.data.repository.CrudRepository;
import no.hvl.dat250.Votesphere.Entities.Vote;


public interface VoteRepository extends CrudRepository<Vote,Long>  {

 //Vote findByVoteId(Long voteId);

 //boolean existsByVoteId(Long voteId);

 //Vote saveVote(Vote vote);

 //List<Vote> findAllVote();
}
