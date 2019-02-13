package com.vivid.partnerships.interview.dto;

import java.util.Date;

import com.vivid.partnerships.interview.entity.Venue;

public class EventDto {

    private Integer id;	
    private String name;	
    private Date date;	
    private Venue venue;
	
	public EventDto() {
	}

	public EventDto(String name, Date date) {
		this.name = name;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}
}
