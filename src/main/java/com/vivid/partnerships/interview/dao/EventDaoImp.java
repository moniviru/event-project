package com.vivid.partnerships.interview.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.vivid.partnerships.interview.entity.Event;

@Repository
public class EventDaoImp implements EventDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Event> getEvents(){
		return entityManager.createQuery("from Event", Event.class).getResultList();
	}
	
	public void createEvent(Event event) {
		entityManager.persist(event);
	}
	
}
