package com.sevilla.clubtor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<TeamModel> getTeamById(@PathVariable(value = "id") Long teamId) {
        return teamService.getTeamById(teamId);
    }

    @PostMapping
    public TeamModel createTeam(@RequestBody TeamModel team) {
        return teamService.createTeam(team);
    }

    @PutMapping("/{id}")
    public TeamModel updateTeam(@PathVariable(value = "id") Long teamId, @RequestBody TeamModel teamDetails) {
        return teamService.updateTeam(teamId, teamDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable(value = "id") Long teamId) {
        teamService.deleteTeam(teamId);
    }
}

