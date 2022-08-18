package tn.Dari.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class JwtAuthenticationResponse {
    private Long id;
    private String username;
    private String accessToken;
    private String tokenType = "Bearer";
    public JwtAuthenticationResponse(String username, String accessToken) {
        super();
        this.username = username;
        this.accessToken = accessToken;
    }
    public JwtAuthenticationResponse(Long id, String username, String accessToken) {
        super();

        this.id = id;
        this.username = username;
        this.accessToken = accessToken;
    }






}