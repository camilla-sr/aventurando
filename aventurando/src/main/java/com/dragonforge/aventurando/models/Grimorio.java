package com.dragonforge.aventurando.models;

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
	private Jogador jogador;
	
	@ManyToOne
	@JoinColumn(name = "i_habilidade_chave")
	private HabilidadeMagia habilidadeMagia;
	
	@ManyToOne
	@JoinColumn(name = "i_magia")
	private GlossarioMagias magia;
	
	@Positive
	private int uso1Max;
	@Positive
	private int uso1Atual;
	@Positive
	private int uso2Max;
	@Positive
	private int uso2Atual;
	@Positive
	private int uso3Max;
	@Positive
	private int uso3Atual;
	@Positive
	private int uso4Max;
	@Positive
	private int uso4Atual;
	@Positive
	private int uso5Max;
	@Positive
	private int uso5Atual;
	@Positive
	private int uso6Max;
	@Positive
	private int uso6Atual;
	@Positive
	private int uso7Max;
	@Positive
	private int uso7Atual;
	@Positive
	private int uso8Max;
	@Positive
	private int uso8Atual;
	@Positive
	private int uso9Max;
	@Positive
	private int uso9Atual;
	
	public Grimorio() {}
	
	public Grimorio(Integer idGrimorio, Jogador jogador, HabilidadeMagia habilidadeMagia, GlossarioMagias magia,
		int uso1Max, int uso1Atual, int uso2Max, int uso2Atual, int uso3Max, int uso3Atual, int uso4Max,
		int uso4Atual, int uso5Max, int uso5Atual, int uso6Max, int uso6Atual, int uso7Max, int uso7Atual,
		int uso8Max, int uso8Atual, int uso9Max, int uso9Atual) {
		this.idGrimorio = idGrimorio; this.jogador = jogador; this.habilidadeMagia = habilidadeMagia;
		this.magia = magia; this.uso1Max = uso1Max; this.uso1Atual = uso1Atual; this.uso2Max = uso2Max;
		this.uso2Atual = uso2Atual; this.uso3Max = uso3Max; this.uso3Atual = uso3Atual; this.uso4Max = uso4Max;
		this.uso4Atual = uso4Atual; this.uso5Max = uso5Max; this.uso5Atual = uso5Atual; this.uso6Max = uso6Max;
		this.uso6Atual = uso6Atual; this.uso7Max = uso7Max; this.uso7Atual = uso7Atual; this.uso8Max = uso8Max;
		this.uso8Atual = uso8Atual; this.uso9Max = uso9Max; this.uso9Atual = uso9Atual;
	}

	public Integer getIdGrimorio() { return idGrimorio; }
	public void setIdGrimorio(Integer idGrimorio) { this.idGrimorio = idGrimorio; }
	public Jogador getJogador() { return jogador; }
	public void setJogador(Jogador jogador) { this.jogador = jogador; }
	public HabilidadeMagia getHabilidadeMagia() { return habilidadeMagia; }
	public void setHabilidadeMagia(HabilidadeMagia habilidadeMagia) { this.habilidadeMagia = habilidadeMagia; }
	public GlossarioMagias getMagia() { return magia; }
	public void setMagia(GlossarioMagias magia) { this.magia = magia; }
	public int getUso1Max() { return uso1Max; }
	public void setUso1Max(int uso1Max) { this.uso1Max = uso1Max; }
	public int getUso1Atual() { return uso1Atual; }
	public void setUso1Atual(int uso1Atual) { this.uso1Atual = uso1Atual; }
	public int getUso2Max() { return uso2Max; }
	public void setUso2Max(int uso2Max) { this.uso2Max = uso2Max; }
	public int getUso2Atual() { return uso2Atual; }
	public void setUso2Atual(int uso2Atual) { this.uso2Atual = uso2Atual; }
	public int getUso3Max() { return uso3Max; }
	public void setUso3Max(int uso3Max) { this.uso3Max = uso3Max; }
	public int getUso3Atual() { return uso3Atual; }
	public void setUso3Atual(int uso3Atual) { this.uso3Atual = uso3Atual; }
	public int getUso4Max() { return uso4Max; }
	public void setUso4Max(int uso4Max) { this.uso4Max = uso4Max; }
	public int getUso4Atual() { return uso4Atual; }
	public void setUso4Atual(int uso4Atual) { this.uso4Atual = uso4Atual; }
	public int getUso5Max() { return uso5Max; }
	public void setUso5Max(int uso5Max) { this.uso5Max = uso5Max; }
	public int getUso5Atual() { return uso5Atual; }
	public void setUso5Atual(int uso5Atual) { this.uso5Atual = uso5Atual; }
	public int getUso6Max() { return uso6Max; }
	public void setUso6Max(int uso6Max) { this.uso6Max = uso6Max; }
	public int getUso6Atual() { return uso6Atual; }
	public void setUso6Atual(int uso6Atual) { this.uso6Atual = uso6Atual; }
	public int getUso7Max() { return uso7Max; }
	public void setUso7Max(int uso7Max) { this.uso7Max = uso7Max; }
	public int getUso7Atual() { return uso7Atual; }
	public void setUso7Atual(int uso7Atual) { this.uso7Atual = uso7Atual; }
	public int getUso8Max() { return uso8Max; }
	public void setUso8Max(int uso8Max) { this.uso8Max = uso8Max; }
	public int getUso8Atual() { return uso8Atual; }
	public void setUso8Atual(int uso8Atual) { this.uso8Atual = uso8Atual; }
	public int getUso9Max() { return uso9Max; }
	public void setUso9Max(int uso9Max) { this.uso9Max = uso9Max; }
	public int getUso9Atual() { return uso9Atual; }
	public void setUso9Atual(int uso9Atual) { this.uso9Atual = uso9Atual; }
}
