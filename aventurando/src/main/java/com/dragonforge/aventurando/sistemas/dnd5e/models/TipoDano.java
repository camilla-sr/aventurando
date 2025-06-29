package com.dragonforge.aventurando.sistemas.dnd5e.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "TIPO_DANO")
public class TipoDano {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDano;
	@NotBlank
	private String descricaoDano;
	
	public TipoDano() {}
	
	public TipoDano(Integer idDano, String descricaoDano) {
		this.idDano = idDano;
		this.descricaoDano = descricaoDano;
	}
	
	public Integer getIdDano() { return idDano; }
	public void setIdDano(Integer idDano) { this.idDano = idDano; }
	public String getDescricaoDano() { return descricaoDano; }
	public void setDescricaoDano(String descricaoDano) { this.descricaoDano = descricaoDano; }
}
