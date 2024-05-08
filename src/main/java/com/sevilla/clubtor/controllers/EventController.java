package com.sevilla.clubtor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sevilla.clubtor.models.EventModel;
import com.sevilla.clubtor.services.EventService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public List<EventModel> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public Optional<EventModel> getEventById(@PathVariable(value = "id") Long eventId) {
        return eventService.getEventById(eventId);
    }

    @PostMapping
    public EventModel createEvent(@RequestBody EventModel event) {
        return eventService.createEvent(event);
    }

    @PutMapping("/{id}")
    public EventModel updateEvent(@PathVariable(value = "id") Long eventId, @RequestBody EventModel eventDetails) {
        return eventService.updateEvent(eventId, eventDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable(value = "id") Long eventId) {
        eventService.deleteEvent(eventId);
    }
}

