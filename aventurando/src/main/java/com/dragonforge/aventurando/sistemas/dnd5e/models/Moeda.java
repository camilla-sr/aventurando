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
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
	@NotBlank @Column(length = 2) private String moeda;
	private Float peso = 0.0f;
	
	public Moeda() {}
	
	public Moeda(Integer id, String moeda, Float peso) {
		this.id = id;
		this.moeda = moeda;
		this.peso = peso;
	}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public String getMoeda() { return moeda; }
	public void setMoeda(String moeda) { this.moeda = moeda; }
	public Float getPeso() { return peso; }
	public void setPeso(Float peso) { this.peso = peso; }
}