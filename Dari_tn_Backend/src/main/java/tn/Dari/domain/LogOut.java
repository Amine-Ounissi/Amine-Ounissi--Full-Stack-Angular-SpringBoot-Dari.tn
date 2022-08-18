package tn.Dari.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;


@Getter
@Setter
@ToString
public class LogOut {
    private Long id;
    private String email;
}
