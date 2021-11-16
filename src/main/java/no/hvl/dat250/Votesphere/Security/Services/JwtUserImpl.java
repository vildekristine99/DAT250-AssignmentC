package no.hvl.dat250.Votesphere.Security.Services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import no.hvl.dat250.Votesphere.DTO.PollUserDTO;
import no.hvl.dat250.Votesphere.Entities.PollUser;

public class JwtUserImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

	private Long userId;

	private String username;

	private String firstname;
    
    private String lastname;

	@JsonIgnore
	private String password;


	public JwtUserImpl(Long userId, String username, String firstname, String lastname, String password) {
		this.userId = userId;
		this.username = username;
		this.firstname = firstname;
        this.lastname = lastname;
		this.password = password;
	}

	public static JwtUserImpl build(PollUserDTO pollUser) {

		return new JwtUserImpl(
				pollUser.getUserId(), 
				pollUser.getUsername(), 
				pollUser.getFirstname(),
				pollUser.getLastname(),
				pollUser.getPassword());
	}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;
    }

    public Long getUserId() {
        return userId;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }
    
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}