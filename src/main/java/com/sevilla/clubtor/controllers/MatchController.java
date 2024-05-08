package com.sevilla.clubtor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<MatchModel> getMatchById(@PathVariable(value = "id") Long matchId) {
        return matchService.getMatchById(matchId);
    }

    @PostMapping
    public MatchModel createMatch(@RequestBody MatchModel match) {
        return matchService.createMatch(match);
    }

    @PutMapping("/{id}")
    public MatchModel updateMatch(@PathVariable(value = "id") Long matchId, @RequestBody MatchModel matchDetails) {
        return matchService.updateMatch(matchId, matchDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteMatch(@PathVariable(value = "id") Long matchId) {
        matchService.deleteMatch(matchId);
    }
}
