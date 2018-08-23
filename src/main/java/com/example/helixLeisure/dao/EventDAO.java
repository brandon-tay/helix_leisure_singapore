package com.example.helixLeisure.dao;

import com.example.helixLeisure.model.Event;

public interface EventDAO {

	public void save(Event event);
	public Event find(long id);
	
}
