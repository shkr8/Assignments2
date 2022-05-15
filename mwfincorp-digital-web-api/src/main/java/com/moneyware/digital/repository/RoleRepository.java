package com.moneyware.digital.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moneyware.digital.models.Role;
import com.moneyware.digital.models.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(RoleName roleName);
}
