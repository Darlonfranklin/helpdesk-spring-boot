package com.darlon.helpdesk.controllers;

import java.util.List;
import java.util.stream.Collectors;

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
public class TechniqueController {

	@Autowired
	private TechniqueService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<TechniqueDTO> findById(@PathVariable Integer id) {
		Technique obj = service.findById(id);
		return ResponseEntity.ok().body(new TechniqueDTO(obj));
	}

	@GetMapping
	public ResponseEntity<List<TechniqueDTO>> findAll() {
		List<Technique> list = service.findAll();
		List<TechniqueDTO> listDTO = list.stream().map(obj -> new TechniqueDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
}
