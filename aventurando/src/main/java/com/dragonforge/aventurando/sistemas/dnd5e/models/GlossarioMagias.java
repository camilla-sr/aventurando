package com.dragonforge.aventurando.sistemas.dnd5e.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "GLOSSARIO_MAGIAS")
public class GlossarioMagias {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
	@NotBlank private String magia;
	@NotEmpty private Integer nivel;
	@NotBlank private String descricaoMagia;
	
	public GlossarioMagias() {}
	
	public GlossarioMagias(Integer id, String magia, Integer nivel, String descricaoMagia) {
		this.id = id;
		this.magia = magia;
		this.nivel = nivel;
		this.descricaoMagia = descricaoMagia;
	}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public String getMagia() { return magia; }
	public void setMagia(String magia) { this.magia = magia; }
	public Integer getNivel() { return nivel; }
	public void setNivel(Integer nivel) { this.nivel = nivel; }
	public String getDescricaoMagia() { return descricaoMagia; }
	public void setDescricaoMagia(String descricaoMagia) { this.descricaoMagia = descricaoMagia; }
}