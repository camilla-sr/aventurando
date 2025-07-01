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
@Table(name = "ARMADURAS")
public class Armadura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idArmadura;
	@NotBlank
	private String tipo;
	@Positive
	private Integer preco;
	@OneToOne
	@JoinColumn(name = "i_moeda")
	private Moeda moeda;
	@Positive
	private Integer classeArmadura;
	private String modificador;
	private String requisito;
	private String desvantagem;
	@Positive
	private Float peso = 0.0f;
	
	public Armadura() {}
	
	public Armadura(Integer idArmadura, String tipo, Integer preco, Moeda moeda, Integer classeArmadura, String modificador,
			String requisito, String desvantagem, Float peso) {
		this.idArmadura = idArmadura;
		this.tipo = tipo;
		this.preco = preco;
		this.moeda = moeda;
		this.classeArmadura = classeArmadura;
		this.modificador = modificador;
		this.requisito = requisito;
		this.desvantagem = desvantagem;
		this.peso = peso;
	}

	public Integer getIdArmadura() { return idArmadura; }
	public void setIdArmadura(Integer idArmadura) { this.idArmadura = idArmadura; }
	public String getTipo() {return tipo; }
	public void setTipo(String tipo) { this.tipo = tipo; }
	public Integer getPreco() { return preco; }
	public void setPreco(Integer preco) { this.preco = preco; }
	public Moeda getMoeda() { return moeda; }
	public void setMoeda(Moeda moeda) { this.moeda = moeda; }
	public Integer getClasseArmadura() { return classeArmadura; }
	public void setClasseArmadura(Integer classeArmadura) { this.classeArmadura = classeArmadura; }
	public String getModificador() { return modificador; }
	public void setModificador(String modificador) { this.modificador = modificador; }
	public String getRequisito() { return requisito; }
	public void setRequisito(String requisito) { this.requisito = requisito; }
	public String getDesvantagem() { return desvantagem; }
	public void setDesvantagem(String desvantagem) { this.desvantagem = desvantagem; }
	public Float getPeso() { return peso; }
	public void setPeso(Float peso) { this.peso = peso; }
}