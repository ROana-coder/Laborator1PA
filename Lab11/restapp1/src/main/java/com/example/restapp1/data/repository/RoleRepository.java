package com.example.restapp1.data.repository;

import com.example.restapp1.data.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByRoleName(String name);
}
