package com.sevilla.clubtor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevilla.clubtor.models.MatchModel;
import com.sevilla.clubtor.repositories.IMatchRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    @Autowired
    private IMatchRepository matchRepository;

    public List<MatchModel> getAllMatches() {
        return matchRepository.findAll();
    }

    public Optional<MatchModel> getMatchById(Long matchId) {
        return matchRepository.findById(matchId);
    }

    public MatchModel createMatch(MatchModel match) {
        return matchRepository.save(match);
    }

    public MatchModel updateMatch(Long matchId, MatchModel matchDetails) {
        return matchRepository.save(matchDetails);
    }

    public void deleteMatch(Long matchId) {
        matchRepository.deleteById(matchId);
    }
}
