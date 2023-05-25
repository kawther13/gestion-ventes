package com.kawthar.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kawthar.pfe.model.Role;

public interface RoleRepo extends JpaRepository<Role, Long>{
 Role findByNomRole(String nomRole);
}
