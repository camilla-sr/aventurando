package com.dragonforge.aventurando.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Rotas {
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@GetMapping("index")
	public String indexJogador() {
		return "index_jogador";
	}
}
