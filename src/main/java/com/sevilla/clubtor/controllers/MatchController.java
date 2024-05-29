package com.sevilla.clubtor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sevilla.clubtor.models.MatchModel;
import com.sevilla.clubtor.services.MatchService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @GetMapping
    public List<MatchModel> getAllMatches() {
        return matchService.getAllMatches();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchModel> getMatchById(@PathVariable(value = "id") Long matchId) {
        Optional<MatchModel> match = matchService.getMatchById(matchId);
        if (match.isPresent()) {
            return ResponseEntity.ok().body(match.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public MatchModel createMatch(@RequestBody MatchModel match) {
        return matchService.createMatch(match);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatchModel> updateMatch(@PathVariable(value = "id") Long matchId, @RequestBody MatchModel matchDetails) {
        Optional<MatchModel> match = matchService.getMatchById(matchId);
        if (match.isPresent()) {
            MatchModel updatedMatch = matchService.updateMatch(matchId, matchDetails);
            return ResponseEntity.ok(updatedMatch);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable(value = "id") Long matchId) {
        Optional<MatchModel> match = matchService.getMatchById(matchId);
        if (match.isPresent()) {
            matchService.deleteMatch(matchId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

