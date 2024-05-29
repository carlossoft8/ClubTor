package com.sevilla.clubtor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevilla.clubtor.models.ClubModel;
import com.sevilla.clubtor.repositories.IClubRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClubService {

    @Autowired
    private IClubRepository clubRepository;

    public List<ClubModel> getAllClubs() {
        return clubRepository.findAll();
    }

    public Optional<ClubModel> getClubById(Long clubId) {
        return clubRepository.findById(clubId);
    }

    public ClubModel createClub(ClubModel club) {
        return clubRepository.save(club);
    }

    public ClubModel updateClub(Long clubId, ClubModel clubDetails) {
        clubDetails.setId(clubId);
        return clubRepository.save(clubDetails);
    }

    public void deleteClub(Long clubId) {
        clubRepository.deleteById(clubId);
    }
}
