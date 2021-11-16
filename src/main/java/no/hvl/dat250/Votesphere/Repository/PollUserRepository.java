package no.hvl.dat250.Votesphere.Repository;

import no.hvl.dat250.Votesphere.Entities.PollUser;
import org.springframework.data.repository.CrudRepository;

public interface PollUserRepository extends CrudRepository<PollUser, Long> {

    PollUser findByUserId(Long userId);

    PollUser deleteByUserId(Long userId);

    PollUser findByUsername(String username);

    

    boolean existsByUsername(String username);
/*
    PollUser savePollUser(PollUser pu);

    */


}
