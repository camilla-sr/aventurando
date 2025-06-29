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
@Table(name = "INVENTARIO")
public class Inventario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idInventario;
	
	@OneToOne
	@JoinColumn(name = "i_jogador")
	private Jogador jogador;
	
	@ManyToOne
	@JoinColumn(name = "i_deposito")
	private Deposito deposito;
	
	@ManyToOne
	@JoinColumn(name = "i_arsenal")
	private Arsenal arsenal;
	
	@ManyToOne
	@JoinColumn(name = "i_mochila")
	private Mochila mochila;
	
	@ManyToOne
	@JoinColumn(name = "i_utilitarios")
	private Utilitarios utilitarios;
	
	@ManyToOne
	@JoinColumn(name = "i_tranqueiras")
	private Tranqueiras tranqueiras;
	
	@Positive
	private int cobre;
	@Positive
	private int prata;
	@Positive
	private int electro;
	@Positive
	private int ouro;
	@Positive
	private int platina;
	
	public Inventario() {}
	
	public Inventario(Integer idInventario, Jogador jogador, Deposito deposito, Arsenal arsenal, Mochila mochila,
		Utilitarios utilitarios, Tranqueiras tranqueiras, int cobre, int prata, int electro, int ouro, int platina) {
		this.idInventario = idInventario; this.jogador = jogador; this.deposito = deposito; this.arsenal = arsenal;
		this.mochila = mochila; this.utilitarios = utilitarios; this.tranqueiras = tranqueiras;
	}

	public Integer getIdInventario() { return idInventario; }
	public void setIdInventario(Integer idInventario) { this.idInventario = idInventario; }
	public Jogador getJogador() { return jogador; }
	public void setJogador(Jogador jogador) { this.jogador = jogador; }
	public Deposito getDeposito() { return deposito; }
	public void setDeposito(Deposito deposito) { this.deposito = deposito; }
	public Arsenal getArsenal() { return arsenal; }
	public void setArsenal(Arsenal arsenal) { this.arsenal = arsenal; }
	public Mochila getMochila() { return mochila; }
	public void setMochila(Mochila mochila) { this.mochila = mochila; }
	public Utilitarios getUtilitarios() { return utilitarios; }
	public void setUtilitarios(Utilitarios utilitarios) { this.utilitarios = utilitarios; }
	public Tranqueiras getTranqueiras() { return tranqueiras; }
	public void setTranqueiras(Tranqueiras tranqueiras) { this.tranqueiras = tranqueiras; }
	public int getCobre() { return cobre; }
	public void setCobre(int cobre) { this.cobre = cobre; }
	public int getPrata() { return prata; }
	public void setPrata(int prata) { this.prata = prata; }
	public int getElectro() { return electro; }
	public void setElectro(int electro) { this.electro = electro; }
	public int getOuro() { return ouro; }
	public void setOuro(int ouro) { this.ouro = ouro; }
	public int getPlatina() { return platina; }
	public void setPlatina(int platina) { this.platina = platina; }
}
