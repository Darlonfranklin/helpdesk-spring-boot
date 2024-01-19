package com.darlon.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darlon.helpdesk.domain.Person;
import com.darlon.helpdesk.domain.Technique;
import com.darlon.helpdesk.domain.dtos.TechniqueDTO;
import com.darlon.helpdesk.repositories.PersonRepository;
import com.darlon.helpdesk.repositories.TechniqueRepository;
import com.darlon.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.darlon.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class TechniqueService {

	@Autowired
	private TechniqueRepository repository;

	@Autowired
	private PersonRepository personRepository;

	public Technique findById(Integer id) {
		Optional<Technique> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object Not Found! " + id));
	}

	public List<Technique> findAll() {
		return repository.findAll();
	}

	public Technique create(TechniqueDTO objDTO) {
		objDTO.setId(null);
		validForCpfAndEmail(objDTO);
		Technique newObj = new Technique(objDTO);
		return repository.save(newObj);
	}

	private void validForCpfAndEmail(TechniqueDTO objDTO) {
		Optional<Person> obj = personRepository.findByCpf(objDTO.getCpf());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF already exists");
		}

		obj = personRepository.findByEmail(objDTO.getEmail());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("E-mail already exists");
		}
	}

}
