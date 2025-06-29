package com.dragonforge.aventurando.sistemas.dnd5e.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "DADOS")
public class Dado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDado;
	@NotBlank
	private String tipo;
	
	public Dado() {}
	
	public Dado(Integer idDado, String tipo) {
		this.idDado = idDado;
		this.tipo = tipo;
	}
	
	public Integer getIdDado() { return idDado; }
	public void setIdDado(Integer idDado) { this.idDado = idDado; }
	public String getTipo() { return tipo; }
	public void setTipo(String tipo) { this.tipo = tipo; }
}