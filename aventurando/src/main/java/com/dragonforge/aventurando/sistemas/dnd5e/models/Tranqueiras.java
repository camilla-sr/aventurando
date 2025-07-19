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
@Table(name = "TRANQUEIRAS")
public class Tranqueiras {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
	@ManyToOne @JoinColumn(name = "i_bugiganga") private Bugiganga bugiganga;
	@Positive private Integer quantidade;
	
	public Tranqueiras() {}
	
	public Tranqueiras(Integer id, Bugiganga bugiganga, Integer quantidade) {
		this.id = id;
		this.bugiganga = bugiganga;
		this.quantidade = quantidade;
	}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public Bugiganga getBugiganga() { return bugiganga; }
	public void setBugiganga(Bugiganga bugiganga) { this.bugiganga = bugiganga; }
	public Integer getQuantidade() { return quantidade; }
	public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }
}