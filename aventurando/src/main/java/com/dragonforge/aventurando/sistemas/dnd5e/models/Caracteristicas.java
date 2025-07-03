package com.dragonforge.aventurando.sistemas.dnd5e.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "CARACTERISTICAS")
public class Caracteristicas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCaracteristica;
	
	@ManyToOne
	@JoinColumn(name = "i_jogador")
	private Integer jogador;
	@ManyToOne
	@JoinColumn(name = "i_traco_personalizado")
	private TracoPersonalidade traco;
	@ManyToOne
	@JoinColumn(name = "i_ideal")
	private Ideal ideal;
	@ManyToOne
	@JoinColumn(name = "i_vinculo")
	private Vinculo vinculo;
	@ManyToOne
	@JoinColumn(name = "i_defeito")
	private Defeito defeito;
	
	private String foto = "";
	@Positive
	private Integer idade;
	@Positive
	private Float peso = 0.0f;
	private String cabelos;
	private String olhos;
	private String pele;
	private String caracteristicaPersonalizada;
	private String historia;
	private String aliadosOrg;
	private String tesouro;
	
	public Caracteristicas() {}
	
	public Caracteristicas(Integer idCaracteristica, Integer jogador, String foto, Integer idade,
			Float peso, String cabelos, String olhos, String pele, String caracteristicaPersonalizada,
			TracoPersonalidade traco, Ideal ideal, Vinculo vinculo, Defeito defeito, String historia,
			String aliadosOrg, String tesouro) {
		this.idCaracteristica = idCaracteristica; this.jogador = jogador; this.foto = foto; this.idade = idade;
		this.peso = peso; this.cabelos = cabelos; this.olhos = olhos; this.pele = pele; this.tesouro = tesouro;
		this.caracteristicaPersonalizada = caracteristicaPersonalizada; this.traco = traco; this.ideal = ideal;
		this.vinculo = vinculo; this.defeito = defeito; this.historia = historia;this.aliadosOrg = aliadosOrg;
	}

	public Integer getIdCaracteristica() { return idCaracteristica; }
	public void setIdCaracteristica(Integer idCaracteristica) { this.idCaracteristica = idCaracteristica; }
	public Integer getJogador() { return jogador; }
	public void setJogador(Integer jogador) { this.jogador = jogador; }
	public TracoPersonalidade getTraco() { return traco; }
	public void setTraco(TracoPersonalidade traco) { this.traco = traco; }
	public Ideal getIdeal() { return ideal; }
	public void setIdeal(Ideal ideal) { this.ideal = ideal; }
	public Vinculo getVinculo() { return vinculo; }
	public void setVinculo(Vinculo vinculo) { this.vinculo = vinculo; }
	public Defeito getDefeito() { return defeito; }
	public void setDefeito(Defeito defeito) { this.defeito = defeito;	}
	public String getFoto() { return foto; }
	public void setFoto(String foto) { this.foto = foto; }
	public Integer getIdade() { return idade; }
	public void setIdade(Integer idade) { this.idade = idade; }
	public Float getPeso() { return peso; }
	public void setPeso(Float peso) { this.peso = peso; }
	public String getCabelos() { return cabelos; }
	public void setCabelos(String cabelos) { this.cabelos = cabelos; }
	public String getOlhos() { return olhos; }
	public void setOlhos(String olhos) { this.olhos = olhos; }
	public String getPele() { return pele; }
	public void setPele(String pele) { this.pele = pele; }
	public String getCaracteristicaPersonalizada() { return caracteristicaPersonalizada; }
	public void setCaracteristicaPersonalizada(String caracteristicaPersonalizada) { this.caracteristicaPersonalizada = caracteristicaPersonalizada; }
	public String getHistoria() { return historia; }
	public void setHistoria(String historia) { this.historia = historia; }
	public String getAliadosOrg() { return aliadosOrg; }
	public void setAliadosOrg(String aliadosOrg) { this.aliadosOrg = aliadosOrg; }
	public String getTesouro() { return tesouro; }
	public void setTesouro(String tesouro) { this.tesouro = tesouro; }
}