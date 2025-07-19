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
@Table(name = "MOCHILA")
public class Mochila {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
	@ManyToOne @JoinColumn(name = "i_item") private Equipamento item;
	@Positive private Integer quantidade;
	
	public Mochila() {}
	
	public Mochila(Integer id, Equipamento item, Integer quantidade) {
		this.id = id;
		this.item = item;
		this.quantidade = quantidade;
	}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public Equipamento getItem() { return item; }
	public void setItem(Equipamento item) { this.item = item; }
	public Integer getQuantidade() { return quantidade; }
	public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }	
}