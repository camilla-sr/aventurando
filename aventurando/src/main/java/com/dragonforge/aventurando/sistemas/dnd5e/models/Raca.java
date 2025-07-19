package com.dragonforge.aventurando.sistemas.dnd5e.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "RACAS")
public class Raca {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
	@NotBlank private String raca;
	@NotBlank private Float deslocamento;
	
	public Raca() {}
	
	public Raca(Integer id, String raca, Float deslocamento) {
		this.id = id;
		this.raca = raca;
		this.deslocamento = deslocamento;
	}
	
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public String getRaca() { return raca; }
	public void setRaca(String raca) { this.raca = raca; }
	public Float getDeslocamento() { return deslocamento; }
	public void setDeslocamento(Float deslocamento) { this.deslocamento = deslocamento; }
}