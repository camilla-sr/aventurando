package com.dragonforge.aventurando.sistemas.dnd5e.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "MAGIAS_PERSONAGEM")
public class MagiasPersonagem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRegistro;
	private String tipo = "";
	@ManyToOne
	@JoinColumn(name = "i_jogador")
	private Jogador jogador;
	
	@ManyToOne
	@JoinColumn(name = "i_magia")
	private GlossarioMagias magia;
	
	@ManyToOne
	@JoinColumn(name = "i_classe")
	private Classe classe;
	
	public MagiasPersonagem() {}
	
	public MagiasPersonagem(Integer idRegistro, Jogador jogador, GlossarioMagias magia, Classe classe) {
		this.idRegistro = idRegistro;
		this.jogador = jogador;
		this.magia = magia;
		this.classe = classe;
	}

	public Integer getIdRegistro() { return idRegistro; }
	public void setIdRegistro(Integer idRegistro) { this.idRegistro = idRegistro; }
	public String getTipo() { return tipo; }
	public void setTipo(String tipo) { this.tipo = tipo; }
	public Jogador getJogador() { return jogador; }
	public void setJogador(Jogador jogador) { this.jogador = jogador; }
	public GlossarioMagias getMagia() { return magia; }
	public void setMagia(GlossarioMagias magia) { this.magia = magia; }
	public Classe getClasse() { return classe; }
	public void setClasse(Classe classe) { this.classe = classe; }
}
