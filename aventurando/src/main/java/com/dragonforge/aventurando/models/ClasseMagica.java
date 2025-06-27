package com.dragonforge.aventurando.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLASSES_MAGIA")
public class ClasseMagica {			//ISSO AQUI É PRA LIGAR CLASSES NAS MAGIAS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idLigacao;
	@ManyToOne
	@JoinColumn(name = "i_magia")
	private GlossarioMagias magia;
	
	@ManyToOne
	@JoinColumn(name = "i_classe")
	private Classe classe;
	
	@ManyToOne
	@JoinColumn(name = "i_habilidade")
	private HabilidadeMagia habilidade;
	
	public ClasseMagica() {}
	
	public ClasseMagica(Integer idLigacao, GlossarioMagias magia, Classe classe, HabilidadeMagia habilidade) {
		this.idLigacao = idLigacao;
		this.magia = magia;
		this.classe = classe;
		this.habilidade = habilidade;
	}

	public Integer getIdLigacao() { return idLigacao; }
	public void setIdLigacao(Integer idLigacao) { this.idLigacao = idLigacao; }
	public GlossarioMagias getMagia() { return magia; }
	public void setMagia(GlossarioMagias magia) { this.magia = magia; }
	public Classe getClasse() { return classe; }
	public void setClasse(Classe classe) { this.classe = classe; }
	public HabilidadeMagia getHabilidade() { return habilidade; }
	public void setHabilidade(HabilidadeMagia habilidade) { this.habilidade = habilidade; }
}
