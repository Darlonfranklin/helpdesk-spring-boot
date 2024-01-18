package com.darlon.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.darlon.helpdesk.domain.Called;

public interface CalledRepository extends JpaRepository<Called, Integer> {

}
