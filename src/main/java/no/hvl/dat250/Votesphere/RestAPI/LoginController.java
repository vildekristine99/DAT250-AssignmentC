package no.hvl.dat250.Votesphere.RestAPI;
import no.hvl.dat250.Votesphere.DAO.EntityDAO;
import no.hvl.dat250.Votesphere.Entities.Vote;
import org.springframework.web.bind.annotation.*;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class LoginController {
    private static final String template = "You voted %s!";
    private final AtomicInteger counter = new AtomicInteger();
    private EntityDAO entityDAO = new EntityDAO();

    @GetMapping("/userlogin") // kanskje noe / id her?
    public Set<Vote> voteResult(@RequestParam int id) {
        return entityDAO.retrievePoll(id).getVotes();
    }
}