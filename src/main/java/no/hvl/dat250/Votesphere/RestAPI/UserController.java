package no.hvl.dat250.Votesphere.RestAPI;

import no.hvl.dat250.Votesphere.DTO.MapService;
import no.hvl.dat250.Votesphere.DTO.PollUserDTO;
import no.hvl.dat250.Votesphere.Entities.Poll;
import no.hvl.dat250.Votesphere.Entities.PollUser;
import no.hvl.dat250.Votesphere.Repository.PollRepository;
import no.hvl.dat250.Votesphere.Repository.PollUserRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private MapService mapService;

    @Autowired
    private PollUserRepository pollUserRepository;

    @GetMapping("/users")
    @ResponseBody
    public List<PollUserDTO> getAllUsers() {
        List<PollUserDTO> pollUsers = mapService.getAllPollUsers();
        return pollUsers;
    }

    @GetMapping("/users/{id}")
    @ResponseBody
    public ResponseEntity<PollUserDTO> getUserById(@PathVariable Long id) {
        PollUserDTO pollUser = mapService.getPollUserById(id);

        if (pollUser != null) {
            return new ResponseEntity<>(pollUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

  /* @PutMapping("/users/{id}")
    public ResponseEntity<PollUser> updatePollUser(@RequestBody PollUser newPollUser, @PathVariable Long id) {
        try {
            return new ResponseEntity<>(pollUserRepository.findById(id)
                    .map(pollUser -> {
                        pollUser.setUsername(newPollUser.getUsername());
                        pollUser.setFirstname(newPollUser.getFirstname());
                        pollUser.setLastname(newPollUser.getLastname());
                        // make update
                        return pollUserRepository.save(pollUser)
                    })
                    .orElseGet(() -> {
                        newPollUser.setId(id);
                        return pollUserRepository.save(newPollUser);
                    }), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }
*/
    @PostMapping("/register")
    public ResponseEntity<PollUser> newPollUser(@RequestBody PollUser newUser) {
        try {
            PollUser pollUser =
                pollUserRepository.save(newUser);
            return new ResponseEntity<>(pollUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/users")
    public ResponseEntity<HttpStatus> deleteAllPollUsers() {

        try {
            pollUserRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deletePollUser(@PathVariable Long id) {
        try{
            pollUserRepository.deleteByUserId(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
     }

     /*@GetMapping("/users/{id}/polls")
    public List<PollDTO> getPollsByUser(@PathVariable Long id) {
        try {

        }
    }
    */
}
