package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Idioma;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.IdiomaRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/idioma-api")
public class IdiomaController {
	@Autowired private IdiomaRepository repo;
	
	@PostMapping
	public String salvar(@Valid Idioma idioma, BindingResult result, @RequestParam("url") String url) {
		if(result.hasErrors()) { return "redirect:" + url + "?codigo=06"; }
		
		if(idioma.getId() != null) {
			Idioma existe = repo.findById(idioma.getId()).orElse(new Idioma());
			
			if(!idioma.getDescricaoIdioma().isEmpty()) { existe.setDescricaoIdioma(idioma.getDescricaoIdioma()); }
			if(!idioma.getAlfabeto().isEmpty()) { existe.setAlfabeto(idioma.getAlfabeto()); }

			repo.save(existe);
			return "redirect:" + url + "?codigo=12";
		}else{
			repo.save(idioma);
			return "redirect:" + url + "?codigo=07";
		}
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@RequestParam Integer id, @RequestParam("url") String url) {
		repo.deleteById(id);
		return "redirect:" + url + "?codigo=15";
	}
}