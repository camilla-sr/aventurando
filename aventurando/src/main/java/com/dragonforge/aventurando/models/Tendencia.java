package com.dragonforge.aventurando.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "TENDENCIAS")
public class Tendencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTendencia;
	@NotBlank
	private String tendencia;
	
	public Tendencia() {}
	
	public Tendencia(Integer idTendencia, String tendencia) {
		this.idTendencia = idTendencia;
		this.tendencia = tendencia;
	}
	
	public Integer getIdTendencia() { return idTendencia; }
	public void setIdTendencia(Integer idTendencia) { this.idTendencia = idTendencia; }
	public String getTendencia() { return tendencia; }
	public void setTendencia(String tendencia) { this.tendencia = tendencia; }
}