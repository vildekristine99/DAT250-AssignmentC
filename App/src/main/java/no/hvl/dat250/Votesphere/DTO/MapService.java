package no.hvl.dat250.Votesphere.DTO;

import no.hvl.dat250.Votesphere.Entities.PollUser;
import no.hvl.dat250.Votesphere.Entities.Poll;
import no.hvl.dat250.Votesphere.Repository.PollRepository;
import no.hvl.dat250.Votesphere.Repository.PollUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import java.util.stream.Collectors;

@Service
public class MapService {

    @Autowired
    private PollRepository pollRepository;

    @Autowired
    private PollUserRepository pollUserRepository;


    //PollUsers
    public List<PollUserDTO> getAllPollUsers() {
        return ((List<PollUser>) pollUserRepository
                .findAll())
                .stream()
                .map(this::convertToPollUserDTO)
                .collect(Collectors.toList());
    }

    public PollUserDTO getPollUserById(Long pollUserId) {
        return pollUserRepository
                .findById(pollUserId)
                .stream()
                .map(this::convertToPollUserDTO)
                .collect(Collectors.toList()).get(0);
    }

    private PollUserDTO convertToPollUserDTO(PollUser pollUser) {
        PollUserDTO pollUserDTO = new PollUserDTO();
        pollUserDTO.setUserId(pollUser.getUserId());
        pollUserDTO.setUsername(pollUser.getUsername());
        pollUserDTO.setFirstname(pollUser.getFirstname());
        pollUserDTO.setLastname(pollUser.getLastname());
        return pollUserDTO;
    }


    //Polls
    public List<PollDTO> getAllPolls() {
        return ((List<Poll>) pollRepository
                .findAll())
                .stream()
                .map(this::convertToPollDTO)
                .collect(Collectors.toList());
    }

    public PollDTO getPollbyId(Long pollId) {
        return pollRepository
                .findById(pollId)
                .stream()
                .map(this::convertToPollDTO)
                .collect(Collectors.toList()).get(0);
    }

    public List<PollDTO> getPollbyUser(Long pollUserId) {
        return ((List<Poll>) pollRepository
                .findAll())
                .stream()
                .filter(p -> p.getPollUser().getUserId().equals(pollUserId))
                .map(this::convertToPollDTO)
                .collect(Collectors.toList());
    }

    public List<PollDTO> getPollbyUsername(String username) {
        return ((List<Poll>) pollRepository
                .findAll())
                .stream()
                .filter(p -> p.getPollUser().getUsername().equals(username))
                .map(this::convertToPollDTO)
                .collect(Collectors.toList());
    }

    private PollDTO convertToPollDTO(Poll poll) {
        PollDTO pollDTO = new PollDTO();
        pollDTO.setPollId(poll.getPollId());
        pollDTO.setPollName(poll.getPollName());
        pollDTO.setIsPublic(poll.isPublic());
        pollDTO.setCreatorName(poll.getPollUser().getFirstname() + " " + poll.getPollUser().getLastname());
        pollDTO.setYesVotes(poll.getVotes().stream().filter(v -> v.getValue()).count());
        pollDTO.setNoVotes(poll.getVotes().stream().filter(v -> !v.getValue()).count());
        return pollDTO;
    }



}