package com.dragonforge.aventurando.sistemas.dnd5e.models;

import jakarta.persistence.Column;
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
	@Column(name = "i_jogador")
	private Integer player;
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
	private Integer cobre;
	@Positive
	private Integer prata;
	@Positive
	private Integer electro;
	@Positive
	private Integer ouro;
	@Positive
	private Integer platina;
	
	public Inventario() {}
	
	public Inventario(Integer idInventario, Integer player, Deposito deposito, Arsenal arsenal, Mochila mochila,
		Utilitarios utilitarios, Tranqueiras tranqueiras, Integer cobre, Integer prata, Integer electro, Integer ouro, Integer platina) {
		this.idInventario = idInventario; this.player = player; this.deposito = deposito; this.arsenal = arsenal;
		this.mochila = mochila; this.utilitarios = utilitarios; this.tranqueiras = tranqueiras;
	}

	public Integer getIdInventario() { return idInventario; }
	public void setIdInventario(Integer idInventario) { this.idInventario = idInventario; }
	public Integer getPlayer() { return player; }
	public void setPlayer(Integer player) { this.player = player; }
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
	public Integer getCobre() { return cobre; }
	public void setCobre(Integer cobre) { this.cobre = cobre; }
	public Integer getPrata() { return prata; }
	public void setPrata(Integer prata) { this.prata = prata; }
	public Integer getElectro() { return electro; }
	public void setElectro(Integer electro) { this.electro = electro; }
	public Integer getOuro() { return ouro; }
	public void setOuro(Integer ouro) { this.ouro = ouro; }
	public Integer getPlatina() { return platina; }
	public void setPlatina(Integer platina) { this.platina = platina; }
}
