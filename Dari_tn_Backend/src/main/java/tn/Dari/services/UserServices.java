package tn.Dari.services;

import tn.Dari.entities.User;

import java.util.Optional;

public interface UserServices {
    Optional<User> findById(Long id);
}
