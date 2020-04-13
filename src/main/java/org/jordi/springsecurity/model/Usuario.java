package org.jordi.springsecurity.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

//@Entity 
public class Usuario {

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Id Long id;

    String name;

}