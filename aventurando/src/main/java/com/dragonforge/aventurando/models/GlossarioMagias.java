package com.dragonforge.aventurando.models;

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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMagia;
	@NotBlank
	private String magia;
	@NotEmpty
	private int nivel;
	@NotBlank
	private String descricaoMagia;
	
	public GlossarioMagias() {}
	
	public GlossarioMagias(Integer idMagia, String magia, int nivel, String descricaoMagia) {
		this.idMagia = idMagia;
		this.magia = magia;
		this.nivel = nivel;
		this.descricaoMagia = descricaoMagia;
	}

	public Integer getIdMagia() { return idMagia; }
	public void setIdMagia(Integer idMagia) { this.idMagia = idMagia; }
	public String getMagia() { return magia; }
	public void setMagia(String magia) { this.magia = magia; }
	public int getNivel() { return nivel; }
	public void setNivel(int nivel) { this.nivel = nivel; }
	public String getDescricaoMagia() { return descricaoMagia; }
	public void setDescricaoMagia(String descricaoMagia) { this.descricaoMagia = descricaoMagia; }
}