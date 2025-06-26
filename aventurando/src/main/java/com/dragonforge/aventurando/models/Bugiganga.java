package com.dragonforge.aventurando.models;

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
	private String descricao_bugiganga;
	
	public Bugiganga() {}
	
	public Bugiganga(Integer idBugiganga, String descricao_bugiganga) {
		this.idBugiganga = idBugiganga;
		this.descricao_bugiganga = descricao_bugiganga;
	}
	
	public Integer getIdBugiganga() { return idBugiganga; }
	public void setIdBugiganga(Integer idBugiganga) { this.idBugiganga = idBugiganga; }
	public String getDescricao_bugiganga() { return descricao_bugiganga; }
	public void setDescricao_bugiganga(String descricao_bugiganga) { this.descricao_bugiganga = descricao_bugiganga; }
}
