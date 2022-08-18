package tn.Dari.security;

import lombok.*;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class JwtResponse {
    private String token;
    private Long id;


}