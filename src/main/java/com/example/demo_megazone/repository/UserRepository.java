package com.example.demo_megazone.repository;

import com.example.demo_megazone.data.YN;
import com.example.demo_megazone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByUserIdAndDelYN(String userId, YN yn);
    Optional<User> findByUserIdAndDelYN(String userId, YN yn);
}
