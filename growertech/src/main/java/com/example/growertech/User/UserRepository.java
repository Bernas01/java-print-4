package com.example.growertech.User;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long>{
    
    Optional<AppUser> findByUsername(String username);
    
}
