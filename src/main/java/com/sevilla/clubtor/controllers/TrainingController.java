package com.sevilla.clubtor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sevilla.clubtor.models.TrainingModel;
import com.sevilla.clubtor.services.TrainingService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trainings")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @GetMapping
    public List<TrainingModel> getAllTrainings() {
        return trainingService.getAllTrainings();
    }

    @GetMapping("/{id}")
    public Optional<TrainingModel> getTrainingById(@PathVariable(value = "id") Long trainingId) {
        return trainingService.getTrainingById(trainingId);
    }

    @PostMapping
    public TrainingModel createTraining(@RequestBody TrainingModel training) {
        return trainingService.createTraining(training);
    }

    @PutMapping("/{id}")
    public TrainingModel updateTraining(@PathVariable(value = "id") Long trainingId, @RequestBody TrainingModel trainingDetails) {
        return trainingService.updateTraining(trainingId, trainingDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteTraining(@PathVariable(value = "id") Long trainingId) {
        trainingService.deleteTraining(trainingId);
    }
}

