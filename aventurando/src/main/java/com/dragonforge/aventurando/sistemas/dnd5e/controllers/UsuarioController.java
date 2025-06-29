package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Usuario;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.UsuarioRepository;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/usuario-api")
public class UsuarioController {
	@Autowired
	private UsuarioRepository repo;
	
	@PostConstruct
	private void verificarAdmin() {
		Usuario admin = repo.findByUsuario("admin");
		if(admin == null) {
			Usuario adminPadrao = new Usuario();
			adminPadrao.setNome("Administrador");
			adminPadrao.setUsuario("admin");
			adminPadrao.setSenha("admin");
			adminPadrao.setAcesso("admin");
			repo.save(adminPadrao);
		}
	}
	
	@PostMapping(value = "/salvar")
	public String cadastrarUsuario(@RequestParam String nome, @RequestParam String usuario,
			@RequestParam String senhaValida, @RequestParam String acesso) {
	
		Usuario existe = repo.findByUsuario(usuario);
		if(existe != null) {
			return "redirect:/login?codigo=31";
		}
		
		Usuario novo = new Usuario();
		novo.setNome(nome);
		novo.setUsuario(usuario);
		novo.setSenha(senhaValida);
		novo.setAcesso(acesso);
		
		repo.save(novo);
		return "redirect:/login?codigo=07";
	}
	
	@PostMapping(value = "/logar")
	public String logar(@RequestParam String usuario, @RequestParam String senha, HttpSession session) {
		Usuario user = repo.findByUsuario(usuario);
		if(user == null || !user.getSenha().equals(senha)) {
			return "redirect:/login?codigo=17";
		}
		session.setAttribute("userLogado", user);
		return "redirect:/";
	}
}