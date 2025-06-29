package com.dragonforge.aventurando.sistemas.dnd5e.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "EQUIPAMENTOS")
public class Equipamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idItem;
	@NotBlank
	private String item;
	@Positive
	private int preco;
	@OneToOne
	@JoinColumn(name = "i_moeda")
	private Moeda moeda;
	@Positive
	private float peso = 0.0f;
	
	public Equipamento() {}
	
	public Equipamento(Integer idItem, String item, int preco, Moeda moeda, float peso) {
		this.idItem = idItem;
		this.item = item;
		this.preco = preco;
		this.moeda = moeda;
		this.peso = peso;
	}

	public Integer getIdItem() { return idItem; }
	public void setIdItem(Integer idItem) { this.idItem = idItem; }
	public String getItem() { return item; }
	public void setItem(String item) { this.item = item; }
	public int getPreco() { return preco; }
	public void setPreco(int preco) { this.preco = preco; }
	public Moeda getMoeda() { return moeda; }
	public void setMoeda(Moeda moeda) { this.moeda = moeda; }
	public float getPeso() { return peso; }
	public void setPeso(float peso) { this.peso = peso; }
}
