package com.dragonforge.aventurando.sistemas.dnd5e.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "GRIMORIO")
public class Grimorio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idGrimorio;
	
	@OneToOne
	@JoinColumn(name = "i_jogador")
	private Integer jogador;
	
	@ManyToOne
	@JoinColumn(name = "i_habilidade_chave")
	private HabilidadeMagia habilidadeMagia;
	
	@ManyToOne
	@JoinColumn(name = "i_magia")
	private GlossarioMagias magia;
	
	@Positive
	private Integer uso1Max;
	@Positive
	private Integer uso1Atual;
	@Positive
	private Integer uso2Max;
	@Positive
	private Integer uso2Atual;
	@Positive
	private Integer uso3Max;
	@Positive
	private Integer uso3Atual;
	@Positive
	private Integer uso4Max;
	@Positive
	private Integer uso4Atual;
	@Positive
	private Integer uso5Max;
	@Positive
	private Integer uso5Atual;
	@Positive
	private Integer uso6Max;
	@Positive
	private Integer uso6Atual;
	@Positive
	private Integer uso7Max;
	@Positive
	private Integer uso7Atual;
	@Positive
	private Integer uso8Max;
	@Positive
	private Integer uso8Atual;
	@Positive
	private Integer uso9Max;
	@Positive
	private Integer uso9Atual;
	
	public Grimorio() {}
	
	public Grimorio(Integer idGrimorio, Integer jogador, HabilidadeMagia habilidadeMagia, GlossarioMagias magia,
		Integer uso1Max, Integer uso1Atual, Integer uso2Max, Integer uso2Atual, Integer uso3Max, Integer uso3Atual, Integer uso4Max,
		Integer uso4Atual, Integer uso5Max, Integer uso5Atual, Integer uso6Max, Integer uso6Atual, Integer uso7Max, Integer uso7Atual,
		Integer uso8Max, Integer uso8Atual, Integer uso9Max, Integer uso9Atual) {
		this.idGrimorio = idGrimorio; this.jogador = jogador; this.habilidadeMagia = habilidadeMagia;
		this.magia = magia; this.uso1Max = uso1Max; this.uso1Atual = uso1Atual; this.uso2Max = uso2Max;
		this.uso2Atual = uso2Atual; this.uso3Max = uso3Max; this.uso3Atual = uso3Atual; this.uso4Max = uso4Max;
		this.uso4Atual = uso4Atual; this.uso5Max = uso5Max; this.uso5Atual = uso5Atual; this.uso6Max = uso6Max;
		this.uso6Atual = uso6Atual; this.uso7Max = uso7Max; this.uso7Atual = uso7Atual; this.uso8Max = uso8Max;
		this.uso8Atual = uso8Atual; this.uso9Max = uso9Max; this.uso9Atual = uso9Atual;
	}

	public Integer getIdGrimorio() { return idGrimorio; }
	public void setIdGrimorio(Integer idGrimorio) { this.idGrimorio = idGrimorio; }
	public Integer getJogador() { return jogador; }
	public void setJogador(Integer jogador) { this.jogador = jogador; }
	public HabilidadeMagia getHabilidadeMagia() { return habilidadeMagia; }
	public void setHabilidadeMagia(HabilidadeMagia habilidadeMagia) { this.habilidadeMagia = habilidadeMagia; }
	public GlossarioMagias getMagia() { return magia; }
	public void setMagia(GlossarioMagias magia) { this.magia = magia; }
	public Integer getUso1Max() { return uso1Max; }
	public void setUso1Max(Integer uso1Max) { this.uso1Max = uso1Max; }
	public Integer getUso1Atual() { return uso1Atual; }
	public void setUso1Atual(Integer uso1Atual) { this.uso1Atual = uso1Atual; }
	public Integer getUso2Max() { return uso2Max; }
	public void setUso2Max(Integer uso2Max) { this.uso2Max = uso2Max; }
	public Integer getUso2Atual() { return uso2Atual; }
	public void setUso2Atual(Integer uso2Atual) { this.uso2Atual = uso2Atual; }
	public Integer getUso3Max() { return uso3Max; }
	public void setUso3Max(Integer uso3Max) { this.uso3Max = uso3Max; }
	public Integer getUso3Atual() { return uso3Atual; }
	public void setUso3Atual(Integer uso3Atual) { this.uso3Atual = uso3Atual; }
	public Integer getUso4Max() { return uso4Max; }
	public void setUso4Max(Integer uso4Max) { this.uso4Max = uso4Max; }
	public Integer getUso4Atual() { return uso4Atual; }
	public void setUso4Atual(Integer uso4Atual) { this.uso4Atual = uso4Atual; }
	public Integer getUso5Max() { return uso5Max; }
	public void setUso5Max(Integer uso5Max) { this.uso5Max = uso5Max; }
	public Integer getUso5Atual() { return uso5Atual; }
	public void setUso5Atual(Integer uso5Atual) { this.uso5Atual = uso5Atual; }
	public Integer getUso6Max() { return uso6Max; }
	public void setUso6Max(Integer uso6Max) { this.uso6Max = uso6Max; }
	public Integer getUso6Atual() { return uso6Atual; }
	public void setUso6Atual(Integer uso6Atual) { this.uso6Atual = uso6Atual; }
	public Integer getUso7Max() { return uso7Max; }
	public void setUso7Max(Integer uso7Max) { this.uso7Max = uso7Max; }
	public Integer getUso7Atual() { return uso7Atual; }
	public void setUso7Atual(Integer uso7Atual) { this.uso7Atual = uso7Atual; }
	public Integer getUso8Max() { return uso8Max; }
	public void setUso8Max(Integer uso8Max) { this.uso8Max = uso8Max; }
	public Integer getUso8Atual() { return uso8Atual; }
	public void setUso8Atual(Integer uso8Atual) { this.uso8Atual = uso8Atual; }
	public Integer getUso9Max() { return uso9Max; }
	public void setUso9Max(Integer uso9Max) { this.uso9Max = uso9Max; }
	public Integer getUso9Atual() { return uso9Atual; }
	public void setUso9Atual(Integer uso9Atual) { this.uso9Atual = uso9Atual; }
}