package com.sevilla.clubtor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevilla.clubtor.models.EventModel;
import com.sevilla.clubtor.repositories.IEventRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private IEventRepository eventRepository;

    public List<EventModel> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<EventModel> getEventById(Long eventId) {
        return eventRepository.findById(eventId);
    }

    public EventModel createEvent(EventModel event) {
        return eventRepository.save(event);
    }

    public EventModel updateEvent(Long eventId, EventModel eventDetails) {
        return eventRepository.save(eventDetails);
    }

    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }
}
