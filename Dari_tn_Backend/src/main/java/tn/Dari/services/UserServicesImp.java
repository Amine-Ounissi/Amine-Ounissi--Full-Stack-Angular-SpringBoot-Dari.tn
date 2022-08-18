package tn.Dari.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.Dari.entities.User;
import tn.Dari.repository.UserRepository;

import java.util.Optional;

@Service @AllArgsConstructor
public class UserServicesImp implements UserServices {
    private UserRepository userRepository;
    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findByIdU(id);
    }
}
