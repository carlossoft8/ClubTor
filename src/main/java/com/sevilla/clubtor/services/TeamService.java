package com.sevilla.clubtor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevilla.clubtor.models.TeamModel;
import com.sevilla.clubtor.repositories.ITeamRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private ITeamRepository teamRepository;

    public List<TeamModel> getAllTeams() {
        return teamRepository.findAll();
    }

    public Optional<TeamModel> getTeamById(Long teamId) {
        return teamRepository.findById(teamId);
    }

    public TeamModel createTeam(TeamModel team) {
        return teamRepository.save(team);
    }

    public TeamModel updateTeam(Long teamId, TeamModel teamDetails) {
        teamDetails.setId(teamId);  // Asegurarse de que el ID del equipo esté establecido
        return teamRepository.save(teamDetails);
    }

    public void deleteTeam(Long teamId) {
        teamRepository.deleteById(teamId);
    }
}
