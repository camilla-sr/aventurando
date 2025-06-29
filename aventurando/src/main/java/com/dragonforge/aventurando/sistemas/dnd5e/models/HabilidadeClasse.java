package com.dragonforge.aventurando.sistemas.dnd5e.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "HABILIDADES_CLASSE")
public class HabilidadeClasse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHabilidadeClasse;
	@OneToOne
	@JoinColumn(name = "i_classe")
	private Classe classe;
	@NotBlank
	private String nome;
	@NotBlank
	private String descricaoHabilidadeClasse;
	
	public HabilidadeClasse() {}
	
	public HabilidadeClasse(Integer idHabilidadeClasse, String nome, Classe classe, String descricaoHabilidadeClasse) {
		this.idHabilidadeClasse = idHabilidadeClasse;
		this.classe = classe;
		this.nome = nome;
		this.descricaoHabilidadeClasse = descricaoHabilidadeClasse;
	}

	public Integer getIdHabilidadeClasse() { return idHabilidadeClasse; }
	public void setIdHabilidadeClasse(Integer idHabilidadeClasse) { this.idHabilidadeClasse = idHabilidadeClasse; }
	public Classe getClasse() { return classe; }
	public void setClasse(Classe classe) { this.classe = classe; }
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }
	public String getDescricaoHabilidadeClasse() { return descricaoHabilidadeClasse; }
	public void setDescricaoHabilidadeClasse(String descricaoHabilidadeClasse) { this.descricaoHabilidadeClasse = descricaoHabilidadeClasse; }
}