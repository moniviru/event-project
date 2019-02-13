package com.vivid.partnerships.interview.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivid.partnerships.interview.dao.EventDao;
import com.vivid.partnerships.interview.entity.Event;

@Service
public class EventServiceImp implements EventService {
	
	@Autowired
    private EventDao eventDao;

	@Transactional
     public List<Event> getEvents() {
         return eventDao.getEvents();
    }
	
	@Transactional
    public void createEvent(Event event) {
        eventDao.createEvent(event);
   }
}
