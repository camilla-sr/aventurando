package com.dragonforge.aventurando.central.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.central.models.Sistema;
import com.dragonforge.aventurando.central.repositorios.SistemaRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/sistema-api")
public class SistemaController {
	@Autowired
	private SistemaRepository repo;
	
	@PostMapping(value = "/salvar")
	public String salvar(@Valid Sistema sistema, BindingResult result) {
		if(result.hasErrors()) { return "codigo=06"; }		//DEU ERRO EM ALGUMA COISA
		
		if(sistema.getIdSistema() != null) {
			Sistema existe = repo.findById(sistema.getIdSistema()).orElse(new Sistema());
			
			if(!sistema.getNomeSistema().isEmpty()) { existe.setNomeSistema(sistema.getNomeSistema()); }
			if(!sistema.getSlug().isEmpty()) { existe.setSlug(sistema.getSlug()); }
			if(!sistema.getAutor().isEmpty()) { existe.setAutor(sistema.getAutor()); }
			existe.setAtivo(sistema.getAtivo());
			
			repo.save(existe);
			return "codigo=12";		//EDITADO
		}else{
			repo.save(sistema);
			return "codigo=07";		//CADASTROU
		}
	}
	
	@PostMapping("/apagar")
	public String apagar(@RequestParam Integer id) {
		if(id != null) { repo.deleteById(id); }
		return "codigo=15";		//APAGOU
	}
}