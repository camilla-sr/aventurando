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
@Table(name = "IDEAIS")
public class Ideal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idIdeal;
	@ManyToOne
	@JoinColumn(name = "i_antecedente")
	private Antecedente antecedente;
	@NotBlank
	private String descricaoIdeal;
	
	public Ideal() {}
	
	public Ideal(Integer idIdeal, Antecedente antecedente, String descricaoIdeal) {
		this.idIdeal = idIdeal;
		this.antecedente = antecedente;
		this.descricaoIdeal = descricaoIdeal;
	}

	public Integer getIdIdeal() { return idIdeal; }
	public void setIdIdeal(Integer idIdeal) { this.idIdeal = idIdeal; }
	public Antecedente getAntecedente() { return antecedente; }
	public void setAntecedente(Antecedente antecedente) { this.antecedente = antecedente; }
	public String getDescricaoIdeal() { return descricaoIdeal; }
	public void setDescricaoIdeal(String descricaoIdeal) { this.descricaoIdeal = descricaoIdeal; }
}
