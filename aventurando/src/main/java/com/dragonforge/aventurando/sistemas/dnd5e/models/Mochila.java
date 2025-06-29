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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMochila;
	@ManyToOne
	@JoinColumn(name = "i_item")
	private Equipamento item;
	@Positive
	private int quantidade;
	
	public Mochila() {}
	
	public Mochila(Integer idMochila, Equipamento item, int quantidade) {
		this.idMochila = idMochila;
		this.item = item;
		this.quantidade = quantidade;
	}

	public Integer getIdMochila() { return idMochila; }
	public void setIdMochila(Integer idMochila) { this.idMochila = idMochila; }
	public Equipamento getItem() { return item; }
	public void setItem(Equipamento item) { this.item = item; }
	public int getQuantidade() { return quantidade; }
	public void setQuantidade(int quantidade) { this.quantidade = quantidade; }	
}
