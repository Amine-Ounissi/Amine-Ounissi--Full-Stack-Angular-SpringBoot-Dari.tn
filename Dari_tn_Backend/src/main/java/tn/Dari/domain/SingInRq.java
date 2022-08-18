package tn.Dari.domain;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class SingInRq {
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String phone;

}
