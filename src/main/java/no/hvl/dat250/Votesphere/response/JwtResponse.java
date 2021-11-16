package no.hvl.dat250.Votesphere.response;

public class JwtResponse {

    private final String jwt;

    public JwtResponse(String jwt){
        this.jwt = jwt;
    }

    public String getJwt(){
        return jwt;
    }
}