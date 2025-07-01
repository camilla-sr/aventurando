package com.dragonforge.aventurando.sistemas.dnd5e.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "BUGIGANGAS")
public class Bugiganga {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idBugiganga;
	@NotBlank
	private String descricaoBugiganga;
	
	public Bugiganga() {}
	
	public Bugiganga(Integer idBugiganga, String descricaoBugiganga) {
		this.idBugiganga = idBugiganga;
		this.descricaoBugiganga = descricaoBugiganga;
	}
	
	public Integer getIdBugiganga() { return idBugiganga; }
	public void setIdBugiganga(Integer idBugiganga) { this.idBugiganga = idBugiganga; }
	public String getDescricaoBugiganga() { return descricaoBugiganga; }
	public void setDescricaoBugiganga(String descricaoBugiganga) { this.descricaoBugiganga = descricaoBugiganga; }
}
