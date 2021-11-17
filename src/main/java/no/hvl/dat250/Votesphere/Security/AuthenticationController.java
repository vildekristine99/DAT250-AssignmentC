package no.hvl.dat250.Votesphere.Security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import no.hvl.dat250.Votesphere.Security.Services.JwtUserDetailsService;

import no.hvl.dat250.Votesphere.Security.Services.JwtUserImpl;
import no.hvl.dat250.Votesphere.DTO.PollService;
import no.hvl.dat250.Votesphere.DTO.PollUserDTO;
import no.hvl.dat250.Votesphere.DTO.PollUserService;
import no.hvl.dat250.Votesphere.Entities.PollUser;
import no.hvl.dat250.Votesphere.Payload.request.LoginRequest;
import no.hvl.dat250.Votesphere.Payload.request.SignupRequest;
import no.hvl.dat250.Votesphere.Payload.response.JwtResponse;
import no.hvl.dat250.Votesphere.Payload.response.MessageResponse;
import no.hvl.dat250.Votesphere.Repository.PollRepository;
import no.hvl.dat250.Votesphere.Repository.PollUserRepository;
import no.hvl.dat250.Votesphere.Security.JWT.JwtTokenUtil;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	PollUserService pollUserService;

	@Autowired
	PollService pollService;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtTokenUtil jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		JwtUserImpl userDetails = (JwtUserImpl) authentication.getPrincipal();		
		

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getUserId(), 
												 userDetails.getUsername(), 
												 userDetails.getFirstname(), 
												 userDetails.getLastname()));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (pollUserService.PollUserExists(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		// Create new user's account
		PollUser pollUser = new PollUser();
        pollUser.setUsername(signUpRequest.getUsername());
        pollUser.setFirstname(signUpRequest.getFirstname());
        pollUser.setLastname(signUpRequest.getLastname());
        pollUser.setPassword(encoder.encode(signUpRequest.getPassword()));

		pollUserService.addPollUser(pollUser);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}