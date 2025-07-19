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
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
	@NotBlank private String descricaoIdioma;
	private String alfabeto = "";
	
	public Idioma() {}
	
	public Idioma(Integer id, String descricaoIdioma, String alfabeto) {
		this.id = id;
		this.descricaoIdioma = descricaoIdioma;
		this.alfabeto = alfabeto;
	}
	
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public String getDescricaoIdioma() { return descricaoIdioma; }
	public void setDescricaoIdioma(String descricaoIdioma) { this.descricaoIdioma = descricaoIdioma; }
	public String getAlfabeto() { return alfabeto; }
	public void setAlfabeto(String alfabeto) { this.alfabeto = alfabeto; }
}