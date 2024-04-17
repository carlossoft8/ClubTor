package com.sevilla.clubtor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sevilla.clubtor.models.TeamModel;

@Repository
public interface ITeamRepository extends JpaRepository<TeamModel, Long> {

}
