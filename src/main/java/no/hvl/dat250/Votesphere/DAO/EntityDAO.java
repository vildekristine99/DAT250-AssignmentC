package no.hvl.dat250.Votesphere.DAO;

import no.hvl.dat250.Votesphere.Entities.Poll;
import no.hvl.dat250.Votesphere.Entities.PollUser;
import no.hvl.dat250.Votesphere.Entities.Vote;

import javax.persistence.*;
import java.util.List;

public final class EntityDAO {

    private static final String PERSISTENCE_UNIT_NAME = "votesphere";
    private static EntityManagerFactory factory;
    private static EntityManager em;

    public EntityDAO(){
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();
    }

    public List<Poll> findAllPolls() {
        em.getTransaction().begin();
        return em.createQuery("SELECT p FROM Poll p", Poll.class)
                .getResultList();
    }

    public PollUser retrievePollUser(Long pollUserId) {
        em.getTransaction().begin();
        return em.find(PollUser.class, pollUserId);
    }

    public Poll retrievePoll(Long pollId) {
        return em.find(Poll.class, pollId);
    }

    public Vote retrieveVote(Long voteId) {
        return em.find(Vote.class, voteId);
    }

    public void addPollUserdb(PollUser pollUser){
        em.getTransaction().begin();
        em.persist(pollUser);
        em.getTransaction().commit();

    }

    public void addPolldb(Poll poll){
        em.getTransaction().begin();
        em.persist(poll);
        em.getTransaction().commit();

    }

    public void addVotedb(Vote vote){
        em.getTransaction().begin();
        em.persist(vote);
        em.getTransaction().commit();
    }

    //må oppdater poll hver gang også
    public void addVotedb2(Vote vote, int pollId) {
        em.getTransaction().begin();
        Poll poll = retrievePoll(pollId);
        poll.addVote(vote);
        em.persist(vote);
        //litt usikker på hvordan
        em.merge(poll);
        em.getTransaction().commit();
    }

    public void removePoll(int pollId) {
        em.getTransaction().begin();
        Poll poll = retrievePoll(pollId);
        em.remove(poll);
        em.getTransaction();
    }


}

