package no.hvl.dat250.Votesphere.Repository;

import no.hvl.dat250.Votesphere.Entities.PollUser;
import org.springframework.data.repository.CrudRepository;

public interface PollUserRepository extends CrudRepository<PollUser, Long> {
/*
    PollUser findByUserId(Long userId);

    boolean existsByUserId(Long userId);

    PollUser savePollUser(PollUser pu);

    PollUser deleteByUserId(Long userId);*/


}
