package com.dragonforge.aventurando.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "CLASSES")
public class Classe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idClasse;
	@NotBlank
	private String classe;
	@NotBlank
	private String descricaoClasse;
	@NotBlank
	private String habilidadePrimaria;
	@OneToOne
	@JoinColumn(name = "dado_vida")
	private Dado dadoVida;
	@NotBlank
	private String pArmasArmaduras;
	@NotBlank
	private String pTesteResistencia;
	
	public Classe() {}
	
	public Classe(Integer idClasse, String classe, String descricaoClasse, String habilidadePrimaria, String pArmasArmaduras,
			String pTesteResistencia) {
		this.idClasse = idClasse;
		this.classe = classe;
		this.descricaoClasse = descricaoClasse;
		this.habilidadePrimaria = habilidadePrimaria;
		this.dadoVida = new Dado();
		this.pArmasArmaduras = pArmasArmaduras;
		this.pTesteResistencia = pTesteResistencia;
	}

	public Integer getIdClasse() { return idClasse; }
	public void setIdClasse(Integer idClasse) { this.idClasse = idClasse; }
	public String getClasse() { return classe; }
	public void setClasse(String classe) { this.classe = classe; }
	public String getDescricaoClasse() { return descricaoClasse; }
	public void setDescricaoClasse(String descricaoClasse) { this.descricaoClasse = descricaoClasse; }
	public String getHabilidadePrimaria() { return habilidadePrimaria; }
	public void setHabilidadePrimaria(String habilidadePrimaria) { this.habilidadePrimaria = habilidadePrimaria; }
	public Dado getDadoVida() { return dadoVida; }
	public void setDadoVida(Dado dadoVida) { this.dadoVida = dadoVida; }
	public String getpArmasArmaduras() { return pArmasArmaduras; }
	public void setpArmasArmaduras(String pArmasArmaduras) { this.pArmasArmaduras = pArmasArmaduras; }
	public String getpTesteResistencia() { return pTesteResistencia; }
	public void setpTesteResistencia(String pTesteResistencia) { this.pTesteResistencia = pTesteResistencia; }
}
