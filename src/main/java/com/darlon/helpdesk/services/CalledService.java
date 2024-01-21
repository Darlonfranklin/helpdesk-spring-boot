package com.darlon.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darlon.helpdesk.domain.Called;
import com.darlon.helpdesk.repositories.CalledRepository;
import com.darlon.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class CalledService {

	@Autowired
	private CalledRepository repository;

	public Called findById(Integer id) {
		Optional<Called> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! ID: " + id));
	}

}
