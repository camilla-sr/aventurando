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
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
	@NotBlank private String talento;
	@NotBlank private String descricaoTalento;
	private String requisito = "Não necessário";
	
	public Talento() {}
	
	public Talento(Integer id, String talento, String descricaoTalento, String requisito) {
		this.id = id;
		this.talento = talento;
		this.descricaoTalento = descricaoTalento;
		this.requisito = requisito;
	}
	
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public String getTalento() { return talento; }
	public void setTalento(String talento) { this.talento = talento; }
	public String getDescricaoTalento() { return descricaoTalento; }
	public void setDescricaoTalento(String descricaoTalento) { this.descricaoTalento = descricaoTalento; }
	public String getRequisito() { return requisito; }
	public void setRequisito(String requisito) { this.requisito = requisito; }
}