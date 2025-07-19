package com.dragonforge.aventurando.central.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "SISTEMA")
public class Sistema {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
	@NotBlank private String nomeSistema;
	@NotBlank private String slug;
	private String autor;
	private Boolean ativo = true;
	
	public Sistema() {}
	
	public Sistema(Integer id, String nomeSistema, String slug, String autor, Boolean ativo) {
		this.id = id;
		this.nomeSistema = nomeSistema;
		this.slug = slug;
		this.autor = autor;
		this.ativo = ativo;
	}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public String getNomeSistema() { return nomeSistema; }
	public void setNomeSistema(String nomeSistema) { this.nomeSistema = nomeSistema; }
	public String getSlug() { return slug; }
	public void setSlug(String slug) { this.slug = slug; }
	public String getAutor() { return autor; }
	public void setAutor(String autor) { this.autor = autor; }
	public Boolean getAtivo() { return ativo; }
	public void setAtivo(Boolean ativo) { this.ativo = ativo; }
}