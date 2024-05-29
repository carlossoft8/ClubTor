package com.sevilla.clubtor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sevilla.clubtor.models.TeamModel;
import com.sevilla.clubtor.services.TeamService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<TeamModel> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamModel> getTeamById(@PathVariable(value = "id") Long teamId) {
        Optional<TeamModel> team = teamService.getTeamById(teamId);
        if (team.isPresent()) {
            return ResponseEntity.ok().body(team.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public TeamModel createTeam(@RequestBody TeamModel team) {
        return teamService.createTeam(team);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamModel> updateTeam(@PathVariable(value = "id") Long teamId, @RequestBody TeamModel teamDetails) {
        Optional<TeamModel> team = teamService.getTeamById(teamId);
        if (team.isPresent()) {
            TeamModel updatedTeam = teamService.updateTeam(teamId, teamDetails);
            return ResponseEntity.ok(updatedTeam);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable(value = "id") Long teamId) {
        Optional<TeamModel> team = teamService.getTeamById(teamId);
        if (team.isPresent()) {
            teamService.deleteTeam(teamId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
