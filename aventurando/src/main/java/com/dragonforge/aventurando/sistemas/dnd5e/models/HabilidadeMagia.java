package com.dragonforge.aventurando.sistemas.dnd5e.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "HABILIDADE_MAGIA")
public class HabilidadeMagia {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
	@NotBlank private String habilidadeChave;
	
	public HabilidadeMagia() {}
	
	public HabilidadeMagia(Integer id, String habilidadeChave) {
		this.id = id;
		this.habilidadeChave = habilidadeChave;
	}
	
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public String getHabilidadeChave() { return habilidadeChave; }
	public void setHabilidadeChave(String habilidadeChave) { this.habilidadeChave = habilidadeChave; }
}