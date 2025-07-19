package com.dragonforge.aventurando.sistemas.dnd5e.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "TENDENCIAS")
public class Tendencia {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
	@NotBlank private String tendencia;
	
	public Tendencia() {}
	
	public Tendencia(Integer id, String tendencia) {
		this.id = id;
		this.tendencia = tendencia;
	}
	
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public String getTendencia() { return tendencia; }
	public void setTendencia(String tendencia) { this.tendencia = tendencia; }
}