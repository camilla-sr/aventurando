package com.dragonforge.aventurando.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dragonforge.aventurando.models.Usuario;
import com.dragonforge.aventurando.repositorios.UsuarioRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/usuario-api")
public class UsuarioController {
	@Autowired
	private UsuarioRepository repo;
	
	@PostMapping(value = "/cadastroUsuario")
	public String cadastrarUsuario(@Valid Usuario usu, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/cadastroUsuario?erro=true";
		}
		
		Usuario existe = repo.findByUsuario(usu.getUsuario());
		if(existe != null) {
			return "redirect:/cadastroUsuario?existe=true";
		}
		repo.save(usu);
		return "redirect:/login?sucesso=true";
	}
}
