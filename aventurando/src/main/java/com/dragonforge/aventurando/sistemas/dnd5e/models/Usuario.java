package com.dragonforge.aventurando.sistemas.dnd5e.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "USUARIO")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	@NotBlank
	private String nome;
	@NotBlank
	private String usuario;
	@NotBlank
	private String senha;
	private String acesso;
	
	public Usuario() {}
	
	public Usuario(Integer idUsuario, String nome, String usuario, String senha) {
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public Integer getIdUsuario() { return idUsuario; }
	public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }
	public String getUsuario() { return usuario; }
	public void setUsuario(String usuario) { this.usuario = usuario; }
	public String getSenha() { return senha; }
	public void setSenha(String senha) { this.senha = senha; }
	public String getAcesso() { return acesso; }
	public void setAcesso(String acesso) { this.acesso = acesso; }
}