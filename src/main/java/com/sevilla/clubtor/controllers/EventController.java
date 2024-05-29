package com.sevilla.clubtor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<EventModel> getEventById(@PathVariable(value = "id") Long eventId) {
        Optional<EventModel> event = eventService.getEventById(eventId);
        if (event.isPresent()) {
            return ResponseEntity.ok().body(event.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public EventModel createEvent(@RequestBody EventModel event) {
        return eventService.createEvent(event);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventModel> updateEvent(@PathVariable(value = "id") Long eventId, @RequestBody EventModel eventDetails) {
        Optional<EventModel> event = eventService.getEventById(eventId);
        if (event.isPresent()) {
            EventModel updatedEvent = eventService.updateEvent(eventId, eventDetails);
            return ResponseEntity.ok(updatedEvent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable(value = "id") Long eventId) {
        Optional<EventModel> event = eventService.getEventById(eventId);
        if (event.isPresent()) {
            eventService.deleteEvent(eventId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
