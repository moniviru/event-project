package com.vivid.partnerships.interview.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vivid.partnerships.interview.dto.EventDto;
import com.vivid.partnerships.interview.entity.Event;
import com.vivid.partnerships.interview.service.EventService;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/events")
    public List<EventDto> getEvents() {    	
        return eventService.getEvents().stream().map(eventEntity->{
        	EventDto eventDto = new EventDto();
        	BeanUtils.copyProperties(eventEntity, eventDto); return eventDto;        	
        }).collect(Collectors.toList());
    }
    
    @PostMapping("/saveEvent")
    public void createEvent(@RequestBody EventDto eventDto) {
    	Event eventEntity = new Event();
    	BeanUtils.copyProperties(eventDto, eventEntity); 
        eventService.createEvent(eventEntity);
    }
}
