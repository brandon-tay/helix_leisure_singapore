package com.example.helixLeisure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.helixLeisure.dao.EventDAO;
import com.example.helixLeisure.model.Event;

@RestController
public class MainController {
	
	@Autowired
	private EventDAO eventDAO;
	
	@RequestMapping(value = "/api/get/products", method = RequestMethod.GET)
	public Event getEvents(@RequestParam(value="id") long id) {
		return eventDAO.find(id);
	}
	
	@RequestMapping(value = "/api/put/products", method = RequestMethod.POST)
	public void putEvent(@RequestBody Event event) {
		eventDAO.save(event);
	}
	
}
