package com.darlon.helpdesk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darlon.helpdesk.domain.Called;
import com.darlon.helpdesk.domain.dtos.CalledDTO;
import com.darlon.helpdesk.services.CalledService;

@RestController
@RequestMapping(value = "/calleds")
public class CalledController {

	@Autowired
	private CalledService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<CalledDTO> findById(@PathVariable Integer id) {
		Called obj = service.findById(id);
		return ResponseEntity.ok().body(new CalledDTO(obj));

	}

}
