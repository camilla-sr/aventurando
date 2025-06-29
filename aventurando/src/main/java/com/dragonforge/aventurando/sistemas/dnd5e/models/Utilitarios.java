package com.dragonforge.aventurando.sistemas.dnd5e.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "UTILITARIOS")
public class Utilitarios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUtilitario;
	@ManyToOne
	@JoinColumn(name = "i_ferramenta")
	private Ferramenta ferramenta;
	@Positive
	private int quantidade;
	
	public Utilitarios() {}
	
	public Utilitarios(Integer idUtilitario, Ferramenta ferramenta, int quantidade) {
		this.idUtilitario = idUtilitario;
		this.ferramenta = ferramenta;
		this.quantidade = quantidade;
	}

	public Integer getIdUtilitario() { return idUtilitario; }
	public void setIdUtilitario(Integer idUtilitario) { this.idUtilitario = idUtilitario; }
	public Ferramenta getFerramenta() { return ferramenta; }
	public void setFerramenta(Ferramenta ferramenta) { this.ferramenta = ferramenta; }
	public int getQuantidade() { return quantidade; }
	public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
}