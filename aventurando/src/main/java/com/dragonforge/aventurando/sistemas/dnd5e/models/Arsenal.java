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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idArsenal;
	@ManyToOne
	@JoinColumn(name = "i_arma")
	private Arma arma;
	@Positive
	private int quantidade = 0;
	
	public Arsenal() {}
	
	public Arsenal(Integer idArsenal, Arma arma, int quantidade) {
		this.idArsenal = idArsenal;
		this.arma = arma;
		this.quantidade = quantidade;
	}
	
	public Integer getIdArsenal() { return idArsenal; }
	public void setIdArsenal(Integer idArsenal) { this.idArsenal = idArsenal; }
	public Arma getArma() { return arma; }
	public void setArma(Arma arma) { this.arma = arma; }
	public int getQuantidade() { return quantidade; }
	public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
}
