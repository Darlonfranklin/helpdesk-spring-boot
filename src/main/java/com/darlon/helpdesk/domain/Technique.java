package com.darlon.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

import com.darlon.helpdesk.domain.enums.Profile;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity(name = "tb_technique")
public class Technique extends Person {

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy = "technique")
	private List<Called> called = new ArrayList<>();

	public Technique() {
		super();
		addProfile(Profile.CLIENT);
	}

	public Technique(Integer id, String name, String cpf, String email, String password) {
		super(id, name, cpf, email, password);
		addProfile(Profile.CLIENT);
	}

	public List<Called> getCalled() {
		return called;
	}

	public void setCalled(List<Called> called) {
		this.called = called;
	}

}
