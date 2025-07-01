package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Utilitarios;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Ferramenta;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.UtilitariosRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.FerramentaRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/utilitarios-api")
public class UtilitariosController {
	@Autowired
	private UtilitariosRepository repo;
	@Autowired
	private FerramentaRepository repoTool;
	
	@PostMapping("/salvar")
	public String salvar(@Valid Utilitarios util, @RequestParam("ferramenta") Integer tool, BindingResult result) {
		if(result.hasErrors()) { return "codigo=06"; }
	
		Ferramenta toolSelect = repoTool.findById(tool).orElseThrow();
		
		if(util.getIdUtilitario() != null) {
			Utilitarios existe = repo.findById(util.getIdUtilitario()).orElse(new Utilitarios());
			
			if(toolSelect != null) { existe.setFerramenta(toolSelect); }
			if(util.getQuantidade() != null) { existe.setQuantidade(util.getQuantidade()); }

			repo.save(existe);
			return "codigo=12";
		}else{
			repo.save(util);
			return "codigo=07";
		}
	}
	
	@PostMapping("/apagar")
	public String apagar(@RequestParam Integer id) {
		if(id != null) { repo.deleteById(id); }
		return "codigo=15";		//APAGOU
	}
}