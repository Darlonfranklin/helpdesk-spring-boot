package com.darlon.helpdesk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darlon.helpdesk.domain.Technique;
import com.darlon.helpdesk.domain.dtos.TechniqueDTO;
import com.darlon.helpdesk.services.TechniqueService;

@RestController
@RequestMapping(value = "/techniques")
public class TecnicoController {

	@Autowired
	private TechniqueService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<TechniqueDTO> findById(@PathVariable Integer id) {
		Technique obj = service.findById(id);
		return ResponseEntity.ok().body(new TechniqueDTO(obj));
	}
}
