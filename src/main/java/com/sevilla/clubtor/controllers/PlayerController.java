package com.sevilla.clubtor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<PlayerModel> getPlayerById(@PathVariable(value = "id") Long playerId) {
        Optional<PlayerModel> player = playerService.getPlayerById(playerId);
        if (player.isPresent()) {
            return ResponseEntity.ok().body(player.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public PlayerModel createPlayer(@RequestBody PlayerModel player) {
        return playerService.createPlayer(player);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerModel> updatePlayer(@PathVariable(value = "id") Long playerId, @RequestBody PlayerModel playerDetails) {
        Optional<PlayerModel> player = playerService.getPlayerById(playerId);
        if (player.isPresent()) {
            PlayerModel updatedPlayer = playerService.updatePlayer(playerId, playerDetails);
            return ResponseEntity.ok(updatedPlayer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable(value = "id") Long playerId) {
        Optional<PlayerModel> player = playerService.getPlayerById(playerId);
        if (player.isPresent()) {
            playerService.deletePlayer(playerId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
