package no.hvl.dat250.Votesphere.DAO;

import no.hvl.dat250.Votesphere.Entities.Poll;
import no.hvl.dat250.Votesphere.Entities.PollUser;
import no.hvl.dat250.Votesphere.Entities.Vote;

public class EntityCreator {

    public PollUser createPollUser(String username, String firstname, String lastname, String password) {
        PollUser pollUser = new PollUser();
        pollUser.setUsername(username);
        pollUser.setFirstname(firstname);
        pollUser.setLastname(lastname);
        pollUser.setPassword(password);
        return pollUser;
    }

    public PollUser createTempUser() {
        PollUser pollUser = new PollUser();
        return pollUser;
    }

    public Poll createPoll(String pollName, boolean isPublic, PollUser pollUser) {
        Poll poll = new Poll();
        poll.setPollName(pollName);
        poll.setPublic(isPublic);
        poll.setPollUser(pollUser);
        pollUser.addPoll(poll);
        return poll;
    }

    public Vote createVote(Poll poll, PollUser voter, String value){
        Vote vote = new Vote();
        vote.setPoll(poll);
        vote.setValue(value);;
        poll.addVote(vote);
        return vote;
    }
}

