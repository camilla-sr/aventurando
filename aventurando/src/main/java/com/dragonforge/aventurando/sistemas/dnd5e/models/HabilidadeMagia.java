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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHabilidade;
	@NotBlank
	private String habilidadeChave;
	
	public HabilidadeMagia() {}
	
	public HabilidadeMagia(Integer idHabilidade, String habilidadeChave) {
		this.idHabilidade = idHabilidade;
		this.habilidadeChave = habilidadeChave;
	}
	
	public Integer getIdHabilidade() { return idHabilidade; }
	public void setIdHabilidade(Integer idHabilidade) { this.idHabilidade = idHabilidade; }
	public String getHabilidadeChave() { return habilidadeChave; }
	public void setHabilidadeChave(String habilidadeChave) { this.habilidadeChave = habilidadeChave; }
}