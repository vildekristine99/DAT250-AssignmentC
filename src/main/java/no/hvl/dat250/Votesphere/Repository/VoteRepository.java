package no.hvl.dat250.Votesphere.Repository;
import org.springframework.data.repository.CrudRepository;
import no.hvl.dat250.Votesphere.Entities.Vote;
import java.util.*;

public interface VoteRepository extends CrudRepository<Vote,Integer>  {

 //Vote findByVoteId(int voteId);

 //boolean existsByVoteId(int voteId);

 //Vote saveVote(Vote vote);

 List<Vote> findAllVote();


}
