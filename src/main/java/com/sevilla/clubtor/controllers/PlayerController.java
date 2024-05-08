package com.sevilla.clubtor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sevilla.clubtor.models.PlayerModel;
import com.sevilla.clubtor.services.PlayerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<PlayerModel> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Optional<PlayerModel> getPlayerById(@PathVariable(value = "id") Long playerId) {
        return playerService.getPlayerById(playerId);
    }

    @PostMapping
    public PlayerModel createPlayer(@RequestBody PlayerModel player) {
        return playerService.createPlayer(player);
    }

    @PutMapping("/{id}")
    public PlayerModel updatePlayer(@PathVariable(value = "id") Long playerId, @RequestBody PlayerModel playerDetails) {
        return playerService.updatePlayer(playerId, playerDetails);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable(value = "id") Long playerId) {
        playerService.deletePlayer(playerId);
    }
}