package com.dragonforge.aventurando.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.dragonforge.aventurando.models.Usuario;

import jakarta.servlet.http.HttpSession;

@Controller
public class Rotas {
	@Autowired
	private Sessao s;
	
	@ModelAttribute
	public void userGlobal(HttpSession session, Model model) {
		if(s.loginAtivo(session)) {
			model.addAttribute("userLogado", (Usuario) session.getAttribute("userLogado"));
		}
	}
	
	public String verificaUsuario(HttpSession session, String page) {
		if(!s.loginAtivo(session)) return "login";
		return page;
	}
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String index(HttpSession session, Model model) {
		if(s.verificaAcesso(session, "admin")) return "index_admin";
		if(s.verificaAcesso(session, "jogador")) return "index_jogador";
		if(s.verificaAcesso(session, "mestre")) return "index_mestre";
		return "login";
	}
}