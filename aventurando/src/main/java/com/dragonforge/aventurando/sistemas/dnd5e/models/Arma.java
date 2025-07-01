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
@Table(name = "ARMAS")
public class Arma {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idArma;
	@NotBlank
	private String arma;
	@Positive
	private Integer preco;
	@OneToOne
	@JoinColumn(name = "i_moeda")
	private Moeda moeda;
	@Positive
	private Integer quantidadeDano;
	@OneToOne
	@JoinColumn(name = "i_dado_dano")
	private Dado dadoDano;
	@OneToOne
	@JoinColumn(name = "i_dano")
	private TipoDano dano;
	@Positive
	private Float peso;
	@NotBlank
	private String propriedades = "";
	
	public Arma() {}
	
	public Arma(Integer idArma, String arma, Integer preco, Moeda moeda, Integer quantidadeDano, Dado dadoDano,
		TipoDano dano, Float peso, String propriedades) {
		this.idArma = idArma;
		this.arma = arma;
		this.preco = preco;
		this.moeda = moeda;
		this.quantidadeDano = quantidadeDano;
		this.dadoDano = dadoDano;
		this.dano = dano;
		this.peso = peso;
		this.propriedades = propriedades;
	}

	public Integer getIdArma() { return idArma; }
	public void setIdArma(Integer idArma) { this.idArma = idArma; }
	public String getArma() { return arma; }
	public void setArma(String arma) { this.arma = arma; }
	public Integer getPreco() { return preco; }
	public void setPreco(Integer preco) { this.preco = preco; }
	public Moeda getMoeda() { return moeda; }
	public void setMoeda(Moeda moeda) { this.moeda = moeda; }
	public Integer getQuantidadeDano() { return quantidadeDano; }
	public void setQuantidadeDano(Integer quantidadeDano) { this.quantidadeDano = quantidadeDano; }
	public Dado getDadoDano() { return dadoDano; }
	public void setDadoDano(Dado dadoDano) { this.dadoDano = dadoDano; }
	public TipoDano getDano() { return dano; }
	public void setDano(TipoDano dano) { this.dano = dano; }
	public Float getPeso() { return peso; }
	public void setPeso(Float peso) { this.peso = peso; }
	public String getPropriedades() { return propriedades; }
	public void setPropriedades(String propriedades) { this.propriedades = propriedades; }
}
