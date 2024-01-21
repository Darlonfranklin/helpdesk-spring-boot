package com.darlon.helpdesk.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.darlon.helpdesk.domain.Called;
import com.fasterxml.jackson.annotation.JsonFormat;

public class CalledDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate openingDate = LocalDate.now();
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate closingDate;
	private Integer priority;
	private Integer status;
	private String title;
	private String observation;
	private Integer technique;
	private Integer client;
	private String nameTechnique;
	private String nameClient;

	public CalledDTO() {
		super();
	}

	public CalledDTO(Called obj) {
		super();
		this.id = obj.getId();
		this.openingDate = obj.getOpeningDate();
		this.closingDate = obj.getClosingDate();
		this.priority = obj.getPriority().getCode();
		this.status = obj.getStatus().getCode();
		this.title = obj.getTitle();
		this.observation = obj.getObservation();
		this.technique = obj.getTechnique().getId();
		this.client = obj.getClient().getId();
		this.nameTechnique = obj.getTechnique().getName();
		this.nameClient = obj.getClient().getName();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}

	public LocalDate getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(LocalDate closingDate) {
		this.closingDate = closingDate;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Integer getTechnique() {
		return technique;
	}

	public void setTechnique(Integer technique) {
		this.technique = technique;
	}

	public Integer getClient() {
		return client;
	}

	public void setClient(Integer client) {
		this.client = client;
	}

	public String getNameTechnique() {
		return nameTechnique;
	}

	public void setNameTechnique(String nameTechnique) {
		this.nameTechnique = nameTechnique;
	}

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

}
