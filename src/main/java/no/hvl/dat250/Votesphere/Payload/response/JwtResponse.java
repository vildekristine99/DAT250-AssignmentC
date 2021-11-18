package no.hvl.dat250.Votesphere.Payload.response;

import java.util.List;

import no.hvl.dat250.Votesphere.DTO.PollDTO;
import no.hvl.dat250.Votesphere.Entities.Poll;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
    private String firstname;
    private String lastname;
	private List<PollDTO> polls;

	public JwtResponse(String accessToken, Long id, String username, String firstname, String lastname, List<PollDTO> polls) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.firstname = firstname;
        this.lastname = lastname;
		this.polls = polls;
	}

	public List<PollDTO> getPolls() {
		return polls;
	}

	public void setPolls(List<PollDTO> polls) {
		this.polls = polls;
	}
	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}