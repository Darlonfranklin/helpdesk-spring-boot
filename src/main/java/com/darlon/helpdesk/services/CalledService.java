package com.darlon.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darlon.helpdesk.domain.Called;
import com.darlon.helpdesk.domain.Client;
import com.darlon.helpdesk.domain.Technique;
import com.darlon.helpdesk.domain.dtos.CalledDTO;
import com.darlon.helpdesk.domain.enums.Priority;
import com.darlon.helpdesk.domain.enums.Status;
import com.darlon.helpdesk.repositories.CalledRepository;
import com.darlon.helpdesk.services.exceptions.ObjectNotFoundException;

import jakarta.validation.Valid;

@Service
public class CalledService {

	@Autowired
	private CalledRepository repository;

	@Autowired
	private TechniqueService techniqueService;

	@Autowired
	private ClientService clientService;

	public Called findById(Integer id) {
		Optional<Called> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! ID: " + id));
	}

	public List<Called> findAll() {
		return repository.findAll();
	}

	public Called create(@Valid CalledDTO objDTO) {
		return repository.save(newCalled(objDTO));
	}

	private Called newCalled(CalledDTO obj) {
		Technique technique = techniqueService.findById(obj.getTechnique());
		Client client = clientService.findById(obj.getClient());

		Called called = new Called();
		if (obj.getId() != null) {
			called.setId(obj.getId());
		}

		called.setTechnique(technique);
		called.setClient(client);
		called.setPriority(Priority.toEnum(obj.getPriority()));
		called.setStatus(Status.toEnum(obj.getStatus()));
		called.setTitle(obj.getTitle());
		called.setObservation(obj.getObservation());
		return called;

	}

}
