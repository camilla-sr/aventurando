package com.dragonforge.aventurando.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "ANTECEDENTES")
public class Antecedente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAntecedente;
	@NotBlank
	private String antecedente;
	
	public Antecedente() {}
	
	public Antecedente(Integer idAntecedente, String antecedente) {
		this.idAntecedente = idAntecedente;
		this.antecedente = antecedente;
	}
	
	public Integer getIdAntecedente() { return idAntecedente; }
	public void setIdAntecedente(Integer idAntecedente) { this.idAntecedente = idAntecedente; }
	public String getAntecedente() { return antecedente; }
	public void setAntecedente(String antecedente) { this.antecedente = antecedente; }
}
