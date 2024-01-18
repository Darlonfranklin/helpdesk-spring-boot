package com.darlon.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darlon.helpdesk.domain.Technique;
import com.darlon.helpdesk.repositories.TechniqueRepository;

@Service
public class TechniqueService {

	@Autowired
	private TechniqueRepository repository;

	public Technique findById(Integer id) {
		Optional<Technique> obj = repository.findById(id);
		return obj.orElse(null);
	}

}
