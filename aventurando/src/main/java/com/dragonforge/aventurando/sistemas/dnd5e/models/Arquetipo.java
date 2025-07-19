package com.dragonforge.aventurando.sistemas.dnd5e.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "ARQUETIPOS")
public class Arquetipo {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
	@ManyToOne @JoinColumn(name = "i_classe") private Classe classe;
	@NotBlank private String titulo;
	@NotBlank private String descricaoArquetipo;
	
	public Arquetipo() {}
	
	public Arquetipo(Integer id, Classe classe, String titulo, String descricaoArquetipo) {
		this.id = id;
		this.classe = classe;
		this.titulo = titulo;
		this.descricaoArquetipo = descricaoArquetipo;
	}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public Classe getClasse() { return classe; }
	public void setClasse(Classe classe) { this.classe = classe; }
	public String getTitulo() { return titulo; }
	public void setTitulo(String titulo) { this.titulo = titulo; }
	public String getDescricaoArquetipo() { return descricaoArquetipo; }
	public void setDescricaoArquetipo(String descricaoArquetipo) { this.descricaoArquetipo = descricaoArquetipo; }
}