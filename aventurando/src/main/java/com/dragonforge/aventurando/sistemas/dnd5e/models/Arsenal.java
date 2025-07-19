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
@Table(name = "ARSENAL")
public class Arsenal {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
	@ManyToOne @JoinColumn(name = "i_arma") private Arma arma;
	@Positive private Integer quantidade = 0;
	
	public Arsenal() {}
	
	public Arsenal(Integer id, Arma arma, Integer quantidade) {
		this.id = id;
		this.arma = arma;
		this.quantidade = quantidade;
	}
	
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public Arma getArma() { return arma; }
	public void setArma(Arma arma) { this.arma = arma; }
	public Integer getQuantidade() { return quantidade; }
	public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }
}