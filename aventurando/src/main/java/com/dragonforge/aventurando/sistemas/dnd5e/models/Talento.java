package com.dragonforge.aventurando.sistemas.dnd5e.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "talentos")
public class Talento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTalento;
	@NotBlank
	private String talento;
	@NotBlank
	private String descricao_talento;
	private String requisito = "Não necessário";
	
	public Talento() {}
	
	public Talento(Integer idTalento, String talento, String descricao_talento, String requisito) {
		this.idTalento = idTalento;
		this.talento = talento;
		this.descricao_talento = descricao_talento;
		this.requisito = requisito;
	}
	
	public Integer getIdTalento() { return idTalento; }
	public void setIdTalento(Integer idTalento) { this.idTalento = idTalento; }
	public String getTalento() { return talento; }
	public void setTalento(String talento) { this.talento = talento; }
	public String getDescricao_talento() { return descricao_talento; }
	public void setDescricao_talento(String descricao_talento) { this.descricao_talento = descricao_talento; }
	public String getRequisito() { return requisito; }
	public void setRequisito(String requisito) { this.requisito = requisito; }
}