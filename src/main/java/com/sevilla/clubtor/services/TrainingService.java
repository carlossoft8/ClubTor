package com.sevilla.clubtor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevilla.clubtor.models.TrainingModel;
import com.sevilla.clubtor.repositories.ITrainingRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingService {

    @Autowired
    private ITrainingRepository trainingRepository;

    public List<TrainingModel> getAllTrainings() {
        return trainingRepository.findAll();
    }

    public Optional<TrainingModel> getTrainingById(Long trainingId) {
        return trainingRepository.findById(trainingId);
    }

    public TrainingModel createTraining(TrainingModel training) {
        return trainingRepository.save(training);
    }

    public TrainingModel updateTraining(Long trainingId, TrainingModel trainingDetails) {
        return trainingRepository.save(trainingDetails);
    }

    public void deleteTraining(Long trainingId) {
        trainingRepository.deleteById(trainingId);
    }
}

