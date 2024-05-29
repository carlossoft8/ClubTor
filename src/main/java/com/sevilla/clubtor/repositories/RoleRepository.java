package com.sevilla.clubtor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sevilla.clubtor.models.RoleModel;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Long> {
}
