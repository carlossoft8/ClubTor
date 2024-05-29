package com.sevilla.clubtor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sevilla.clubtor.models.MatchModel;

@Repository
public interface IMatchRepository extends JpaRepository<MatchModel, Long> {
}
