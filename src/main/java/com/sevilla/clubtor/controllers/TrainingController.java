package com.sevilla.clubtor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<TrainingModel> getTrainingById(@PathVariable(value = "id") Long trainingId) {
        Optional<TrainingModel> training = trainingService.getTrainingById(trainingId);
        if (training.isPresent()) {
            return ResponseEntity.ok().body(training.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public TrainingModel createTraining(@RequestBody TrainingModel training) {
        return trainingService.createTraining(training);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrainingModel> updateTraining(@PathVariable(value = "id") Long trainingId, @RequestBody TrainingModel trainingDetails) {
        Optional<TrainingModel> training = trainingService.getTrainingById(trainingId);
        if (training.isPresent()) {
            TrainingModel updatedTraining = trainingService.updateTraining(trainingId, trainingDetails);
            return ResponseEntity.ok(updatedTraining);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTraining(@PathVariable(value = "id") Long trainingId) {
        Optional<TrainingModel> training = trainingService.getTrainingById(trainingId);
        if (training.isPresent()) {
            trainingService.deleteTraining(trainingId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
