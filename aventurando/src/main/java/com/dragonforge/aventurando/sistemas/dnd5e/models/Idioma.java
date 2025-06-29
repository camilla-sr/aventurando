package com.dragonforge.aventurando.sistemas.dnd5e.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "IDIOMAS")
public class Idioma {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idIdioma;
	@NotBlank
	private String descricao_idioma;
	private String alfabeto = "";
	
	public Idioma() {}
	
	public Idioma(Integer idIdioma, String descricao_idioma, String alfabeto) {
		this.idIdioma = idIdioma;
		this.descricao_idioma = descricao_idioma;
		this.alfabeto = alfabeto;
	}
	
	public Integer getIdIdioma() { return idIdioma; }
	public void setIdIdioma(Integer idIdioma) { this.idIdioma = idIdioma; }
	public String getDescricao_idioma() { return descricao_idioma; }
	public void setDescricao_idioma(String descricao_idioma) { this.descricao_idioma = descricao_idioma; }
	public String getAlfabeto() { return alfabeto; }
	public void setAlfabeto(String alfabeto) { this.alfabeto = alfabeto; }
}
