package com.darlon.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.darlon.helpdesk.domain.Person;
import com.darlon.helpdesk.domain.Client;
import com.darlon.helpdesk.domain.dtos.ClientDTO;
import com.darlon.helpdesk.repositories.PersonRepository;
import com.darlon.helpdesk.repositories.ClientRepository;
import com.darlon.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.darlon.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public Client findById(Integer id) {
		Optional<Client> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object Not Found! " + id));
	}

	public List<Client> findAll() {
		return repository.findAll();
	}

	public Client create(ClientDTO objDTO) {
		objDTO.setId(null);
		objDTO.setPassword(encoder.encode(objDTO.getPassword()));
		validForCpfAndEmail(objDTO);
		Client newObj = new Client(objDTO);
		return repository.save(newObj);
	}

	public Client update(Integer id, @Valid ClientDTO objDTO) {
		objDTO.setId(id);
		Client oldObj = findById(id);
		validForCpfAndEmail(objDTO);
		oldObj = new Client(objDTO);
		return repository.save(oldObj);

	}

	public void delete(Integer id) {
		Client obj = findById(id);
		if (obj.getCalled().size() > 0) {
			throw new DataIntegrityViolationException("The client has work orders and cannot be deleted!");
		}
		repository.deleteById(id);
	}

	private void validForCpfAndEmail(ClientDTO objDTO) {
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
