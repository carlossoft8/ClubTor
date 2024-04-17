package com.sevilla.clubtor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sevilla.clubtor.models.TrainingModel;

@Repository
public interface ITrainingRepository extends JpaRepository<TrainingModel, Long> {

}
