package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	@Autowired private UtilitariosRepository repo;
	@Autowired private FerramentaRepository repoTool;
	
	@PostMapping
	public String salvar(@Valid Utilitarios util, @RequestParam("ferramenta") Integer tool, BindingResult result, @RequestParam("url") String url) {
		if(result.hasErrors()) { return "redirect:" + url + "?codigo=06"; }
	
		Ferramenta toolSelect = repoTool.findById(tool).orElseThrow();
		
		if(util.getIdUtilitario() != null) {
			Utilitarios existe = repo.findById(util.getIdUtilitario()).orElse(new Utilitarios());
			
			if(toolSelect != null) { existe.setFerramenta(toolSelect); }
			if(util.getQuantidade() != null) { existe.setQuantidade(util.getQuantidade()); }

			repo.save(existe);
			return "redirect:" + url + "?codigo=12";
		}else{
			repo.save(util);
			return "redirect:" + url + "?codigo=07";
		}
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@RequestParam Integer id, @RequestParam("url") String url) {
		repo.deleteById(id);
		return "redirect:" + url + "?codigo=15";
	}
}