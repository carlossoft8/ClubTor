package com.sevilla.clubtor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sevilla.clubtor.models.PlayerModel;

@Repository
public interface IPlayerRepository extends JpaRepository<PlayerModel, Long> {

}
