package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Dado;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.DadoRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/dado-api")
public class DadoController {
	@Autowired
	private DadoRepository repo;
	
	@PostMapping("/salvar")
	public String salvar(@Valid Dado dado, BindingResult result) {
		if(result.hasErrors()) { return "codigo=06"; }
		
		if(dado.getIdDado() != null) {
			Dado existe = repo.findById(dado.getIdDado()).orElse(new Dado());
			
			if(!dado.getTipo().isEmpty()) { existe.setTipo(dado.getTipo()); }
			
			repo.save(existe);
			return "codigo=12";
		}else{
			repo.save(dado);
			return "codigo=07";
		}
	}
	
	@PostMapping("/apagar")
	public String apagar(@RequestParam Integer id) {
		if(id != null) { repo.deleteById(id); }
		return "codigo=15";		//APAGOU
	}
}
