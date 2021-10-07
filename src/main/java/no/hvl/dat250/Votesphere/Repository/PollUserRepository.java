package no.hvl.dat250.Votesphere.Repository;

import no.hvl.dat250.Votesphere.Entities.PollUser;
import org.springframework.data.repository.CrudRepository;

public interface PollUserRepository extends CrudRepository<PollUser, Integer> {
/*
    PollUser findByUserId(int userId);

    boolean existsByUserId(int userId);

    PollUser savePollUser(PollUser pu);

    PollUser deleteByUserId(int userId);*/


}
