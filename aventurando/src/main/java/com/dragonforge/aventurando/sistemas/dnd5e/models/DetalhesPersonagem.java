package com.dragonforge.aventurando.sistemas.dnd5e.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "DETALHES_PERSONAGEM")
public class DetalhesPersonagem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDetalhes;
	
	@ManyToOne
	@JoinColumn(name = "i_jogador")
	private Integer jogador;
	
	@ManyToOne
	@JoinColumn(name = "i_habilidade_classe")
	private HabilidadeClasse habilidadeClasse;
	
	@ManyToOne
	@JoinColumn(name = "i_habilidade_raca")
	private HabilidadeRaca habilidadeRaca;
	
	@ManyToOne
	@JoinColumn(name = "i_arquetipo")
	private Arquetipo arquetipo;
	
	@ManyToOne
	@JoinColumn(name = "i_talento")
	private Talento talento;
	
	@ManyToOne
	@JoinColumn(name = "i_idioma")
	private Idioma idioma;
	
	@ManyToOne
	@JoinColumn(name = "i_p_arma")		//PROFICIÊNCIA EM ARMAS
	private Arma arma;
	
	@ManyToOne
	@JoinColumn(name = "i_p_armadura")	//PROFICIẼNCIA EM ARMADURAS
	private Armadura armadura;
	
	@ManyToOne
	@JoinColumn(name = "i_p_ferramenta")	//PROFICIÊNCIA EM FERRAMENTA
	private Ferramenta ferramenta;
	
	public DetalhesPersonagem() {}
	
	public DetalhesPersonagem(Integer idDetalhes, Integer jogador, HabilidadeClasse habilidadeClasse,
			HabilidadeRaca habilidadeRaca, Arquetipo arquetipo, Talento talento, Idioma idioma, Arma arma,
			Armadura armadura, Ferramenta ferramenta) {
		this.idDetalhes = idDetalhes;
		this.jogador = jogador;
		this.habilidadeClasse = habilidadeClasse;
		this.habilidadeRaca = habilidadeRaca;
		this.arquetipo = arquetipo;
		this.talento = talento;
		this.idioma = idioma;
		this.arma = arma;
		this.armadura = armadura;
		this.ferramenta = ferramenta;
	}

	public Integer getIdDetalhes() { return idDetalhes; }
	public void setIdDetalhes(Integer idDetalhes) { this.idDetalhes = idDetalhes; }
	public Integer getJogador() { return jogador; }
	public void setJogador(Integer jogador) { this.jogador = jogador; }
	public HabilidadeClasse getHabilidadeClasse() { return habilidadeClasse; }
	public void setHabilidadeClasse(HabilidadeClasse habilidadeClasse) { this.habilidadeClasse = habilidadeClasse; }
	public HabilidadeRaca getHabilidadeRaca() { return habilidadeRaca; }
	public void setHabilidadeRaca(HabilidadeRaca habilidadeRaca) { this.habilidadeRaca = habilidadeRaca; }
	public Arquetipo getArquetipo() { return arquetipo; }
	public void setArquetipo(Arquetipo arquetipo) { this.arquetipo = arquetipo; }
	public Talento getTalento() { return talento; }
	public void setTalento(Talento talento) { this.talento = talento; }
	public Idioma getIdioma() { return idioma; }
	public void setIdioma(Idioma idioma) { this.idioma = idioma; }
	public Arma getArma() { return arma; }
	public void setArma(Arma arma) { this.arma = arma; }
	public Armadura getArmadura() { return armadura; }
	public void setArmadura(Armadura armadura) { this.armadura = armadura; }
	public Ferramenta getFerramenta() { return ferramenta; }
	public void setFerramenta(Ferramenta ferramenta) { this.ferramenta = ferramenta; }
}