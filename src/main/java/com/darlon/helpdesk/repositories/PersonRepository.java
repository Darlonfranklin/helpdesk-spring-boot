package com.darlon.helpdesk.repositories;

import java.util.Optional; 

import org.springframework.data.jpa.repository.JpaRepository;

import com.darlon.helpdesk.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

	Optional<Person> findByCpf(String cpf);

	Optional<Person> findByEmail(String email);

}
