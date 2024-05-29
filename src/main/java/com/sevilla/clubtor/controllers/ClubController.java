package com.sevilla.clubtor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sevilla.clubtor.models.ClubModel;
import com.sevilla.clubtor.services.ClubService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clubs")
public class ClubController {

    @Autowired
    private ClubService clubService;

    @GetMapping
    public List<ClubModel> getAllClubs() {
        return clubService.getAllClubs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClubModel> getClubById(@PathVariable(value = "id") Long clubId) {
        Optional<ClubModel> club = clubService.getClubById(clubId);
        if (club.isPresent()) {
            return ResponseEntity.ok().body(club.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ClubModel createClub(@RequestBody ClubModel club) {
        return clubService.createClub(club);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClubModel> updateClub(@PathVariable(value = "id") Long clubId, @RequestBody ClubModel clubDetails) {
        Optional<ClubModel> club = clubService.getClubById(clubId);
        if (club.isPresent()) {
            ClubModel updatedClub = clubService.updateClub(clubId, clubDetails);
            return ResponseEntity.ok(updatedClub);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClub(@PathVariable(value = "id") Long clubId) {
        Optional<ClubModel> club = clubService.getClubById(clubId);
        if (club.isPresent()) {
            clubService.deleteClub(clubId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
