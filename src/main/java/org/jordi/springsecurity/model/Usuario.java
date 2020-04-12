package org.jordi.springsecurity.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data   
public class Usuario {

    @Id Long id;

    String name;

}