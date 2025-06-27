package com.dragonforge.aventurando.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "DEPOSITO")
public class Deposito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDeposito;
	
	@ManyToOne
	@JoinColumn(name = "i_armadura")
	private Armadura armadura;
	
	@Positive
	private int quantidade = 0;
	
	public Deposito () {}
	
	public Deposito(Integer idDeposito, Armadura armadura, int quantidade) {
		this.idDeposito = idDeposito;
		this.armadura = armadura;
		this.quantidade = quantidade;
	}

	public Integer getIdDeposito() { return idDeposito; }
	public void setIdDeposito(Integer idDeposito) { this.idDeposito = idDeposito; }
	public Armadura getArmadura() { return armadura; }
	public void setArmadura(Armadura armadura) { this.armadura = armadura; }
	public int getQuantidade() { return quantidade; }
	public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
}
