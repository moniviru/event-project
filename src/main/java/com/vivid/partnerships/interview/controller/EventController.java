package com.vivid.partnerships.interview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vivid.partnerships.interview.entity.Event;
import com.vivid.partnerships.interview.service.EventService;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/events")
    public List<Event> getEvents() {
        return eventService.getEvents();
    }
    
    @PostMapping("/saveEvent")
    public void createEvent(@RequestBody Event event) {
        eventService.createEvent(event);
    }
}
