package com.vivid.partnerships.interview.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.vivid.partnerships.interview.constant.ConstantTest;
import com.vivid.partnerships.interview.dao.EventDao;
import com.vivid.partnerships.interview.entity.Event;
import com.vivid.partnerships.interview.service.EventService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventServiceTest {

	@Autowired
	private EventService eventService;
	
	@MockBean
	private EventDao eventDao;
	
	private List<Event> eventList;
	
	@Before
	public void setUp() {		
		eventList = new ArrayList<>();
		eventList.add(new Event(ConstantTest.EVENT_NAME1, new Date()));
		eventList.add(new Event(ConstantTest.EVENT_NAME2, new Date()));		
	    Mockito.when(eventDao.getEvents())
	      .thenReturn(eventList);
	}

	@Test
	public void getAllEventsInList() {		
		List<Event> events = eventService.getEvents();
		assertNotNull(events);
		assertEquals(events.size(), ConstantTest.SIZE_TEST_ARRAY);
	}
	
}
