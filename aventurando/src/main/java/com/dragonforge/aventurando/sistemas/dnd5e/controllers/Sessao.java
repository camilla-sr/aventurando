package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Usuario;

import jakarta.servlet.http.HttpSession;

@Controller
public class Sessao {
	@GetMapping("/logout")
	public String logout (HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
	public boolean loginAtivo(HttpSession session) {
		return session.getAttribute("userLogado") != null;
	}
	
	public boolean verificaAcesso(HttpSession session, String acessoNecessario) {
		if(!loginAtivo(session)) {
			return false;
		}
		return ((Usuario) session.getAttribute("userLogado")).getAcesso().equals(acessoNecessario);
	}
}
