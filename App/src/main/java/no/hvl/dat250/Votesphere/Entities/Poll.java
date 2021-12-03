package no.hvl.dat250.Votesphere.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pollId;
    private String pollName;
    private boolean isPublic;

    @ManyToOne(fetch = FetchType.LAZY)
    private PollUser pollUser;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval=true, mappedBy = "poll")
    private Set<Vote> votes = new HashSet<Vote>();

    public Poll() { }

    public Poll(String pollName, boolean isPublic) {
        this.pollName = pollName;
        this.isPublic = isPublic;
    }

    public void addVote(Vote vote){
        votes.add(vote);
    }

    public Long getPollId() {
        return pollId;
    }

    public String getPollName() {
        return pollName;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public Set<Vote> getVotes() {
        return votes;
    }

    public void setPollId(Long pollId) {
        this.pollId = pollId;
    }

    public void setPollName(String pollName) {
        this.pollName = pollName;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public void setVotes(Set<Vote> votes) {
        this.votes = votes;
    }

    public PollUser getPollUser() {
        return pollUser;
    }

    public void setPollUser(PollUser pollUser) {
        this.pollUser = pollUser;
    }



}