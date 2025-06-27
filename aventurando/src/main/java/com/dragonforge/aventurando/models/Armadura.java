package com.dragonforge.aventurando.models;

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
	private int preco;
	@OneToOne
	@JoinColumn(name = "i_moeda")
	private Moeda moeda;
	@Positive
	private int classeArmadura;
	private String modificador;
	private String requisito;
	private String desvantagem;
	@Positive
	private float peso = 0.0f;
	
	public Armadura() {}
	
	public Armadura(Integer idArmadura, String tipo, int preco, Moeda moeda, int classeArmadura, String modificador,
			String requisito, String desvantagem, float peso) {
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
	public int getPreco() { return preco; }
	public void setPreco(int preco) { this.preco = preco; }
	public Moeda getMoeda() { return moeda; }
	public void setMoeda(Moeda moeda) { this.moeda = moeda; }
	public int getClasseArmadura() { return classeArmadura; }
	public void setClasseArmadura(int classeArmadura) { this.classeArmadura = classeArmadura; }
	public String getModificador() { return modificador; }
	public void setModificador(String modificador) { this.modificador = modificador; }
	public String getRequisito() { return requisito; }
	public void setRequisito(String requisito) { this.requisito = requisito; }
	public String getDesvantagem() { return desvantagem; }
	public void setDesvantagem(String desvantagem) { this.desvantagem = desvantagem; }
	public float getPeso() { return peso; }
	public void setPeso(float peso) { this.peso = peso; }
}