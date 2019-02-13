package com.vivid.partnerships.interview.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vivid.partnerships.interview.constant.ConstantTest;
import com.vivid.partnerships.interview.dto.EventDto;
import com.vivid.partnerships.interview.entity.Event;
import com.vivid.partnerships.interview.service.EventService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EventControllerTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EventControllerTest.class);

	@Autowired
    private MockMvc mvc;
	
	@Autowired
	ObjectMapper objectMapper;
 
    @MockBean
    private EventService eventService;
    
    private List<Event> eventList;
    
    private EventDto eventDto;
    
    @Before
	public void setUp() {		
    	
    	eventDto = new EventDto(ConstantTest.EVENT_NAME1, new Date());
		eventList = new ArrayList<>();
		eventList.add(new Event(ConstantTest.EVENT_NAME1, new Date()));
		eventList.add(new Event(ConstantTest.EVENT_NAME2, new Date()));		
	    Mockito.when(eventService.getEvents())
	      .thenReturn(eventList);
	    
	    
	}
    
    @Test
    public void givenEventsThenReturnJsonArray()
      throws Exception {   
        mvc.perform(get("/events")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(jsonPath(ConstantTest.JSON_PATH, is(ConstantTest.EVENT_NAME1)));
    }
    
    @Test
    public void createEventThroughPostService() {
        try {
			mvc.perform(post("/saveEvent")
			        .contentType(MediaType.APPLICATION_JSON)
			        .content(objectMapper.writeValueAsString(eventDto)))
			        .andExpect(status().isOk());
		} catch (JsonProcessingException e) {
			LOGGER.error(e.getMessage());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
    }
	
}
