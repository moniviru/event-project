package com.vivid.partnerships.interview.service;

import java.util.List;

import com.vivid.partnerships.interview.entity.Event;

public interface EventService {

	public List<Event> getEvents();
	
	public void createEvent(Event event);
}
