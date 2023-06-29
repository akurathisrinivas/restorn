package com.auth.authService.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.authService.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
