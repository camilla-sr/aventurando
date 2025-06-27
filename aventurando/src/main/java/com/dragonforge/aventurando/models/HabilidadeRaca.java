package com.dragonforge.aventurando.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "HABILIDADES_RACA")
public class HabilidadeRaca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHabilidadeRaca;
	@ManyToOne
	@JoinColumn(name = "i_raca")
	private Raca raca;
	@NotBlank
	private String nome;
	@NotBlank
	private String descricaoHabilidadeRaca;
	
	public HabilidadeRaca() {}
	
	public HabilidadeRaca(Integer idHabilidadeRaca, Raca raca, String nome, String descricaoHabilidadeRaca) {
		this.idHabilidadeRaca = idHabilidadeRaca;
		this.raca = raca;
		this.nome = nome;
		this.descricaoHabilidadeRaca = descricaoHabilidadeRaca;
	}

	public Integer getIdHabilidadeRaca() { return idHabilidadeRaca; }
	public void setIdHabilidadeRaca(Integer idHabilidadeRaca) { this.idHabilidadeRaca = idHabilidadeRaca; }
	public Raca getRaca() { return raca; }
	public void setRaca(Raca raca) { this.raca = raca; }
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }
	public String getDescricaoHabilidadeRaca() { return descricaoHabilidadeRaca; }
	public void setDescricaoHabilidadeRaca(String descricaoHabilidadeRaca) { this.descricaoHabilidadeRaca = descricaoHabilidadeRaca; }
}
