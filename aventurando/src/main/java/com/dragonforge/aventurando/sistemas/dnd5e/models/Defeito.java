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
@Table(name = "DEFEITOS")
public class Defeito {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
	@ManyToOne @JoinColumn(name = "i_antecedente") private Antecedente antecedente;
	@NotBlank private String descricaoDefeito;
	
	public Defeito() {}
	
	public Defeito(Integer id, Antecedente antecedente, String descricaoDefeito) {
		this.id = id;
		this.antecedente = antecedente;
		this.descricaoDefeito = descricaoDefeito;
	}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public Antecedente getAntecedente() { return antecedente; }
	public void setAntecedente(Antecedente antecedente) { this.antecedente = antecedente; }
	public String getDescricaoDefeito() { return descricaoDefeito; }
	public void setDescricaoDefeito(String descricaoDefeito) { this.descricaoDefeito = descricaoDefeito; }
}