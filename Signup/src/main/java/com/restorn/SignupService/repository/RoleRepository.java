package com.restorn.SignupService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restorn.SignupService.models.ERole;
import com.restorn.SignupService.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
    Optional<Role> findByName(ERole name);


}
