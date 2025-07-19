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
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
	@ManyToOne @JoinColumn(name = "i_ferramenta") private Ferramenta ferramenta;
	@Positive private Integer quantidade;
	
	public Utilitarios() {}
	
	public Utilitarios(Integer id, Ferramenta ferramenta, Integer quantidade) {
		this.id = id;
		this.ferramenta = ferramenta;
		this.quantidade = quantidade;
	}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public Ferramenta getFerramenta() { return ferramenta; }
	public void setFerramenta(Ferramenta ferramenta) { this.ferramenta = ferramenta; }
	public Integer getQuantidade() { return quantidade; }
	public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }
}