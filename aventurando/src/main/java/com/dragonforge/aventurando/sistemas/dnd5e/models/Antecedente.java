package com.dragonforge.aventurando.sistemas.dnd5e.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "ANTECEDENTES")
public class Antecedente {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
	@NotBlank private String antecedente;
	
	public Antecedente() {}
	
	public Antecedente(Integer id, String antecedente) {
		this.id = id;
		this.antecedente = antecedente;
	}
	
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public String getAntecedente() { return antecedente; }
	public void setAntecedente(String antecedente) { this.antecedente = antecedente; }
}