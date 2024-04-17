package com.sevilla.clubtor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sevilla.clubtor.models.ClubModel;

@Repository
public interface IClubRepository extends JpaRepository<ClubModel, Long> {

}
