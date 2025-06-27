package com.dragonforge.aventurando.models;

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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTraco;
	@ManyToOne
	@JoinColumn(name = "i_antecedente")
	private Antecedente antecedente;
	@NotBlank
	private String descricaoTraco;
	
	public TracoPersonalidade() {}
	
	public TracoPersonalidade(Integer idTraco, String descricaoTraco, Antecedente antecedente) {
		this.idTraco = idTraco;
		this.antecedente = antecedente;
		this.descricaoTraco = descricaoTraco;
	}

	public Integer getIdTraco() { return idTraco; }
	public void setIdTraco(Integer idTraco) { this.idTraco = idTraco; }
	public Antecedente getAntecedente() { return antecedente; }
	public void setAntecedente(Antecedente antecedente) { this.antecedente = antecedente; }
	public String getDescricaoTraco() { return descricaoTraco; }
	public void setDescricaoTraco(String descricaoTraco) { this.descricaoTraco = descricaoTraco; }
}
