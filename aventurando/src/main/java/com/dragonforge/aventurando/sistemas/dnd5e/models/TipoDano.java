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
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
	@NotBlank private String descricaoDano;
	
	public TipoDano() {}
	
	public TipoDano(Integer id, String descricaoDano) {
		this.id = id;
		this.descricaoDano = descricaoDano;
	}
	
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public String getDescricaoDano() { return descricaoDano; }
	public void setDescricaoDano(String descricaoDano) { this.descricaoDano = descricaoDano; }
}