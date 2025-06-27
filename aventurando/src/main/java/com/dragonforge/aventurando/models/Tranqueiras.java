package com.dragonforge.aventurando.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "TRANQUEIRAS")
public class Tranqueiras {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTranqueira;
	@ManyToOne
	@JoinColumn(name = "i_bugiganga")
	private Bugiganga bugiganga;
	@Positive
	private int quantidade;
	
	public Tranqueiras() {}
	
	public Tranqueiras(Integer idTranqueira, Bugiganga bugiganga, int quantidade) {
		this.idTranqueira = idTranqueira;
		this.bugiganga = bugiganga;
		this.quantidade = quantidade;
	}

	public Integer getIdTranqueira() { return idTranqueira; }
	public void setIdTranqueira(Integer idTranqueira) { this.idTranqueira = idTranqueira; }
	public Bugiganga getBugiganga() { return bugiganga; }
	public void setBugiganga(Bugiganga bugiganga) { this.bugiganga = bugiganga; }
	public int getQuantidade() { return quantidade; }
	public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
}
