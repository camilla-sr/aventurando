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
@Table(name = "DEFEITOS")
public class Defeito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDefeito;
	@ManyToOne
	@JoinColumn(name = "i_antecedente")
	private Antecedente antecedente;
	@NotBlank
	private String descricaoDefeito;
	
	public Defeito() {}
	
	public Defeito(Integer idDefeito, Antecedente antecedente, String descricaoDefeito) {
		this.idDefeito = idDefeito;
		this.antecedente = antecedente;
		this.descricaoDefeito = descricaoDefeito;
	}

	public Integer getIdDefeito() { return idDefeito; }
	public void setIdDefeito(Integer idDefeito) { this.idDefeito = idDefeito; }
	public Antecedente getAntecedente() { return antecedente; }
	public void setAntecedente(Antecedente antecedente) { this.antecedente = antecedente; }
	public String getDescricaoDefeito() { return descricaoDefeito; }
	public void setDescricaoDefeito(String descricaoDefeito) { this.descricaoDefeito = descricaoDefeito; }
}
