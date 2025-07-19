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
@Table(name = "TRACO_PERSONALIDADE")
public class TracoPersonalidade {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
	@ManyToOne @JoinColumn(name = "i_antecedente") private Antecedente antecedente;
	@NotBlank private String descricaoTraco;
	
	public TracoPersonalidade() {}
	
	public TracoPersonalidade(Integer id, String descricaoTraco, Antecedente antecedente) {
		this.id = id;
		this.antecedente = antecedente;
		this.descricaoTraco = descricaoTraco;
	}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public Antecedente getAntecedente() { return antecedente; }
	public void setAntecedente(Antecedente antecedente) { this.antecedente = antecedente; }
	public String getDescricaoTraco() { return descricaoTraco; }
	public void setDescricaoTraco(String descricaoTraco) { this.descricaoTraco = descricaoTraco; }
}