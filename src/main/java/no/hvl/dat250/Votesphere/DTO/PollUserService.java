package no.hvl.dat250.Votesphere.DTO;

import no.hvl.dat250.Votesphere.Entities.PollUser;

import no.hvl.dat250.Votesphere.Repository.PollRepository;
import no.hvl.dat250.Votesphere.Repository.PollUserRepository;
import no.hvl.dat250.Votesphere.Repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PollUserService {


    @Autowired
    private PollUserRepository pollUserRepository;

   

    public PollUser addPollUser(PollUser pollUser) {
        return pollUserRepository.save(pollUser);
    }

    public void deletePollUser(Long id) {
        pollUserRepository.deleteByUserId(id);
    }

    public PollUserDTO getPollUserDTOById(Long id) {
        if (pollUserRepository.findById(id).isPresent()) {
            PollUser pollUser = pollUserRepository.findById(id).get();
            return new PollUserDTO(pollUser.getUserId(), pollUser.getUsername(), pollUser.getFirstname(), pollUser.getLastname() , pollUser.getPassword());
        } else {
            return null;
        }
    }

    public List<PollUserDTO> getPollUsers() {
        List<PollUserDTO> pollUserList = new ArrayList<>();

        pollUserRepository.findAll().forEach(pollUser -> {
            pollUserList.add(new PollUserDTO(pollUser.getUserId(), pollUser.getUsername(), pollUser.getFirstname(), pollUser.getLastname(), pollUser.getPassword()));
        });
        return pollUserList;
    }

    public PollUserDTO getPollUser(String username) {
        PollUser pollUser = pollUserRepository.findByUsername(username);

        PollUserDTO dto = new PollUserDTO(pollUser.getUserId(), pollUser.getUsername(), pollUser.getFirstname(), pollUser.getLastname(), pollUser.getPassword());

        return dto;
    }

}