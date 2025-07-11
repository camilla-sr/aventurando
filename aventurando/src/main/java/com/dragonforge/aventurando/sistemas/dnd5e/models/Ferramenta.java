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
@Table(name = "FERRAMENTAS")
public class Ferramenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFerramenta;
	@NotBlank
	private String ferramenta;
	private String descricaoFerramenta;
	@Positive
	private Integer preco;
	@OneToOne
	@JoinColumn(name = "i_moeda")
	private Moeda moeda;
	@Positive
	private Float peso = 0.0f;
	
	public Ferramenta() {}
	
	public Ferramenta(Integer idFerramenta, String ferramenta, String descricaoFerramenta, Integer preco, Moeda moeda, Float peso) {
		this.idFerramenta = idFerramenta;
		this.ferramenta = ferramenta;
		this.descricaoFerramenta = descricaoFerramenta;
		this.preco = preco;
		this.moeda = moeda;
		this.peso = peso;
	}

	public Integer getIdFerramenta() { return idFerramenta; }
	public void setIdFerramenta(Integer idFerramenta) { this.idFerramenta = idFerramenta; }
	public String getFerramenta() { return ferramenta; }
	public void setFerramenta(String ferramenta) { this.ferramenta = ferramenta; }
	public String getDescricaoFerramenta() { return descricaoFerramenta; }
	public void setDescricaoFerramenta(String descricaoFerramenta) { this.descricaoFerramenta = descricaoFerramenta; }
	public Integer getPreco() { return preco; }
	public void setPreco(Integer preco) {this.preco = preco; }
	public Moeda getMoeda() { return moeda; }
	public void setMoeda(Moeda moeda) { this.moeda = moeda; }
	public Float getPeso() { return peso; }
	public void setPeso(Float peso) { this.peso = peso; }
}
