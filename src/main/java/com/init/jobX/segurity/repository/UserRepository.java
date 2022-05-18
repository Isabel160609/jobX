package com.init.jobX.segurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.init.jobX.segurity.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String userName);
    boolean existsByUsername(String userName);
    boolean existsByEmail(String email);

}
