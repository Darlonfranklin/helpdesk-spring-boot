package com.darlon.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.darlon.helpdesk.domain.Technique;

public interface TechniqueRepository extends JpaRepository<Technique, Integer> {

}
