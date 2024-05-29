package com.sevilla.clubtor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sevilla.clubtor.services.ReportService;

import java.util.Map;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/financial")
    public Map<String, Object> getFinancialReport() {
        return reportService.generateFinancialReport();
    }

    @GetMapping("/player-stats")
    public Map<String, Object> getPlayerStatsReport() {
        return reportService.generatePlayerStatsReport();
    }
}
