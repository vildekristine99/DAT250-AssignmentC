package no.hvl.dat250.Votesphere.Entities;

import no.hvl.dat250.Votesphere.Entities.Poll;

import javax.persistence.*;

@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteId;

    @ManyToOne
    private Poll poll;

    private boolean value;

    public Vote () {

    }

    public Vote(Long voteId, Poll poll, boolean value) {
        this.voteId = voteId;
        this.poll = poll;
        this.value = value;
    }

    public Long getVoteId() {
        return voteId;
    }

    public Poll getPoll() {
        return poll;
    }

    public boolean getValue() {
        return value;
    }

    public void setVoteId(Long voteId) {
        this.voteId = voteId;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public void setValue(boolean value) {
        this.value = value;
    }


}