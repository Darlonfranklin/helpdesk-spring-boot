package com.darlon.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.darlon.helpdesk.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
