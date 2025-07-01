package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Bugiganga;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.BugigangaRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/bugiganga-api")
public class BugigangaController {
	@Autowired
	private BugigangaRepository repo;
	
	@PostMapping("/salvar")
	public String salvar(@Valid Bugiganga bugi, BindingResult result) {
		if(result.hasErrors()) { return "codigo=06"; }
		
		if(bugi.getIdBugiganga() != null) {
			Bugiganga existe = repo.findById(bugi.getIdBugiganga()).orElse(new Bugiganga());
			if(!bugi.getDescricaoBugiganga().isEmpty()) { existe.setDescricaoBugiganga(bugi.getDescricaoBugiganga()); }
			
			repo.save(existe);
			return "codigo=12";
		}else{
			repo.save(bugi);
			return "codigo=07";
		}
	}
	
	@PostMapping("/apagar")
	public String apagar(@RequestParam Integer id) {
		if(id != null) { repo.deleteById(id); }
		return "codigo=15";		//APAGOU
	}
}