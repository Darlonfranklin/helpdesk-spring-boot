package com.darlon.helpdesk.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.darlon.helpdesk.domain.Technique;
import com.darlon.helpdesk.domain.dtos.TechniqueDTO;
import com.darlon.helpdesk.services.TechniqueService;

import jakarta.validation.Valid;

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

	@PostMapping
	public ResponseEntity<TechniqueDTO> create(@Valid @RequestBody TechniqueDTO objDTO) {
		Technique newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<TechniqueDTO> update(@PathVariable Integer id, @Valid @RequestBody TechniqueDTO objDTO) {
		Technique obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new TechniqueDTO(obj));
	}
}
