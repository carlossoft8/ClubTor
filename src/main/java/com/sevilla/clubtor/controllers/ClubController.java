package com.sevilla.clubtor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<ClubModel> getClubById(@PathVariable(value = "id") Long clubId) {
        return clubService.getClubById(clubId);
    }

    @PostMapping
    public ClubModel createClub(@RequestBody ClubModel club) {
        return clubService.createClub(club);
    }

    @PutMapping("/{id}")
    public ClubModel updateClub(@PathVariable(value = "id") Long clubId, @RequestBody ClubModel clubDetails) {
        return clubService.updateClub(clubId, clubDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteClub(@PathVariable(value = "id") Long clubId) {
        clubService.deleteClub(clubId);
    }
}

