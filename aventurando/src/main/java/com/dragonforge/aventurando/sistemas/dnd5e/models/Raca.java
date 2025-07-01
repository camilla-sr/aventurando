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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRaca;
	@NotBlank
	private String raca;
	@NotBlank
	private Float deslocamento;
	
	public Raca() {}
	
	public Raca(Integer idRaca, String raca, Float deslocamento) {
		this.idRaca = idRaca;
		this.raca = raca;
		this.deslocamento = deslocamento;
	}
	
	public Integer getIdRaca() { return idRaca; }
	public void setIdRaca(Integer idRaca) { this.idRaca = idRaca; }
	public String getRaca() { return raca; }
	public void setRaca(String raca) { this.raca = raca; }
	public Float getDeslocamento() { return deslocamento; }
	public void setDeslocamento(Float deslocamento) { this.deslocamento = deslocamento; }
}