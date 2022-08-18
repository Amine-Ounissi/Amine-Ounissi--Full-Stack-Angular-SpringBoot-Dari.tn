package tn.Dari.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import tn.Dari.domain.JwtRequest;
import tn.Dari.domain.SingInRq;
import tn.Dari.entities.User;
import tn.Dari.repository.UserRepository;
import tn.Dari.security.JwtResponse;
import tn.Dari.security.JwtTokenUtil;
import tn.Dari.security.JwtUserDetailsService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @PostMapping("/singin")
    public ResponseEntity<?> singIn( @RequestBody SingInRq singInRq) {
        boolean testIfExist=userRepository.existsByEmail(singInRq.getEmail());
        if(!testIfExist)
        {
            userRepository.save(new User(singInRq.getName(),singInRq.getLastName(),singInRq.getEmail(),passwordEncoder.encode(singInRq.getPassword()),singInRq.getPhone()));
            return new ResponseEntity<Void>(HttpStatus.OK);
        }else
        {
            return new ResponseEntity<Void>(HttpStatus.FOUND);
        }

    }
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
       Optional<User>  user = userRepository.findByEmail(authenticationRequest.getEmail());


           authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

           final UserDetails userDetails = userDetailsService
                   .loadUserByUsername(authenticationRequest.getEmail());

           final String token = jwtTokenUtil.generateToken(userDetails);

           return ResponseEntity.ok(new JwtResponse(token,user.get().getIdU()));


    }

    private void authenticate(String username, String password) throws Exception {
        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}