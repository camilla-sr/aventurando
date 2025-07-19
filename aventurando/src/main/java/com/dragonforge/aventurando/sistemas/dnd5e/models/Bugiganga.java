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
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
	@NotBlank private String descricaoBugiganga;
	
	public Bugiganga() {}
	
	public Bugiganga(Integer id, String descricaoBugiganga) {
		this.id = id;
		this.descricaoBugiganga = descricaoBugiganga;
	}
	
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public String getDescricaoBugiganga() { return descricaoBugiganga; }
	public void setDescricaoBugiganga(String descricaoBugiganga) { this.descricaoBugiganga = descricaoBugiganga; }
}