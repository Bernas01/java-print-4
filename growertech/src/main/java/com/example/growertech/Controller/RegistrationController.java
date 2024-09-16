package com.example.growertech.Controller;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.growertech.User.*;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    
    // Método para consumir requisições com x-www-form-urlencoded
    @PostMapping(value = "/req/signup", consumes = "application/x-www-form-urlencoded")
    public AppUser createUserFromForm(
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password
            ) {
        AppUser user = new AppUser();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        return repository.save(user);
    }
}