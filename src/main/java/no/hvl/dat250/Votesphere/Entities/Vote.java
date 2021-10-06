package no.hvl.dat250.Votesphere.Entities;

import no.hvl.dat250.Votesphere.Entities.Poll;

import javax.persistence.*;

@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int voteId;

    @ManyToOne
    private Poll poll;

    private String value;

    public Vote () {

    }

    public Vote(int voteId, Poll poll, String value) {
        this.voteId = voteId;
        this.poll = poll;
        this.value = value;
    }

    public int getVoteId() {
        return voteId;
    }

    public Poll getPoll() {
        return poll;
    }

    public String getValue() {
        return value;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public void setValue(String value) {
        this.value = value;
    }


}