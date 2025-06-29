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
@Table(name = "VINCULOS")
public class Vinculo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVinculo;
	@ManyToOne
	@JoinColumn(name = "i_antecedente")
	private Antecedente antecedente;
	@NotBlank
	private String descricaoVinculo;
	
	public Vinculo() {}
	
	public Vinculo(Integer idVinculo, Antecedente antecedente, String descricaoVinculo) {
		this.idVinculo = idVinculo;
		this.antecedente = antecedente;
		this.descricaoVinculo = descricaoVinculo;
	}

	public Integer getIdVinculo() { return idVinculo; }
	public void setIdVinculo(Integer idVinculo) { this.idVinculo = idVinculo; }
	public Antecedente getAntecedente() { return antecedente; }
	public void setAntecedente(Antecedente antecedente) { this.antecedente = antecedente; }
	public String getDescricaoVinculo() { return descricaoVinculo; }
	public void setDescricaoVinculo(String descricaoVinculo) { this.descricaoVinculo = descricaoVinculo; }
}
