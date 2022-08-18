package tn.Dari.security;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.Dari.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;
    //on vas utilisé l'email
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println(passwordEncoder.encode("a"));
        Optional<tn.Dari.entities.User> userBd =userRepository.findByEmail(email);
        if (userBd.isPresent()) {
            System.out.println("is present");
            //password doit être cripté
            return new User(userBd.get().getEmail(), userBd.get().getPassword(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + email);
        }
    }
     /*  Optional<tn.Dari.entities.User> userBd =userRepository.findByEmail(username);
        if (userBd.isPresent()) {
            System.out.println("userBd.isPresent()");
            return new User(userBd.get().getEmail(), passwordEncoder.encode(userBd.get().getPassword()),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }*/
}