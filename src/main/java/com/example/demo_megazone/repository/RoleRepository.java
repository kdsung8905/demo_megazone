package com.example.demo_megazone.repository;

import com.example.demo_megazone.data.YN;
import com.example.demo_megazone.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository  extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleNameAndDelYN(String name, YN yn);

}
