package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Bugiganga;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.BugigangaRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/bugiganga-api")
public class BugigangaController {
	@Autowired private BugigangaRepository repo;
	
	@PostMapping
	public String salvar(@Valid Bugiganga bugi, BindingResult result, @RequestParam("url") String url) {
		if(result.hasErrors()) { return "redirect:" + url + "?codigo=06"; }
		
		if(bugi.getIdBugiganga() != null) {
			Bugiganga existe = repo.findById(bugi.getIdBugiganga()).orElse(new Bugiganga());
			if(!bugi.getDescricaoBugiganga().isEmpty()) { existe.setDescricaoBugiganga(bugi.getDescricaoBugiganga()); }
			
			repo.save(existe);
			return "redirect:" + url + "?codigo=12";
		}else{
			repo.save(bugi);
			return "redirect:" + url + "?codigo=07";
		}
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@RequestParam Integer id, @RequestParam("url") String url) {
		repo.deleteById(id);
		return "redirect:" + url + "?codigo=15";
	}
}