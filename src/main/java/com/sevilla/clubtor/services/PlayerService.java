package com.sevilla.clubtor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevilla.clubtor.models.PlayerModel;
import com.sevilla.clubtor.repositories.IPlayerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private IPlayerRepository playerRepository;

    public List<PlayerModel> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<PlayerModel> getPlayerById(Long playerId) {
        return playerRepository.findById(playerId);
    }

    public PlayerModel createPlayer(PlayerModel player) {
        return playerRepository.save(player);
    }

    public PlayerModel updatePlayer(Long playerId, PlayerModel playerDetails) {
        playerDetails.setId(playerId);  // Asegurarse de que el ID del jugador esté establecido
        return playerRepository.save(playerDetails);
    }

    public void deletePlayer(Long playerId) {
        playerRepository.deleteById(playerId);
    }
}
