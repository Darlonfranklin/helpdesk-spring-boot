package com.darlon.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.darlon.helpdesk.domain.Called;
import com.darlon.helpdesk.domain.Client;
import com.darlon.helpdesk.domain.Technique;
import com.darlon.helpdesk.domain.enums.Priority;
import com.darlon.helpdesk.domain.enums.Profile;
import com.darlon.helpdesk.domain.enums.Status;
import com.darlon.helpdesk.repositories.CalledRepository;
import com.darlon.helpdesk.repositories.ClientRepository;
import com.darlon.helpdesk.repositories.TechniqueRepository;

@Service
public class DBService {

	@Autowired
	private TechniqueRepository techniqueRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private CalledRepository calledRepository;

	@Bean
	public void instanceDB() {
		Technique tech1 = new Technique(null, "Darlon", "111.111.111-11", "darlon@email.com", "123");
		tech1.addProfile(Profile.ADMIN);

		Client cli1 = new Client(null, "Linus Torvalds", "222.222.222.22", "linus@email.com", "123");

		Called c1 = new Called(null, Priority.AVERAGE, Status.PROGRESS, "Called 01", "First Called", tech1, cli1);

		techniqueRepository.saveAll(Arrays.asList(tech1));
		clientRepository.saveAll(Arrays.asList(cli1));
		calledRepository.saveAll(Arrays.asList(c1));
	}

}
