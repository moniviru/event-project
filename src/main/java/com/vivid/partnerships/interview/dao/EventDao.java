package com.vivid.partnerships.interview.dao;

import java.util.List;

import com.vivid.partnerships.interview.entity.Event;

public interface EventDao {
	
	public List<Event> getEvents();
	
	public void createEvent(Event event);
}
