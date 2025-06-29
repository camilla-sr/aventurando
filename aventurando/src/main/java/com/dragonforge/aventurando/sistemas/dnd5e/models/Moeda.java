package com.dragonforge.aventurando.sistemas.dnd5e.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "MOEDA")
public class Moeda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMoeda;
	@NotBlank
	@Column(length = 2)
	private String moeda;
	private float peso = 0.0f;
	
	public Moeda() {}
	
	public Moeda(Integer idMoeda, String moeda, float peso) {
		this.idMoeda = idMoeda;
		this.moeda = moeda;
		this.peso = peso;
	}

	public Integer getIdMoeda() { return idMoeda; }
	public void setIdMoeda(Integer idMoeda) { this.idMoeda = idMoeda; }
	public String getMoeda() { return moeda; }
	public void setMoeda(String moeda) { this.moeda = moeda; }
	public float getPeso() { return peso; }
	public void setPeso(float peso) { this.peso = peso; }
}
