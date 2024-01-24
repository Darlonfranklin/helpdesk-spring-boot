package com.darlon.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.darlon.helpdesk.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
