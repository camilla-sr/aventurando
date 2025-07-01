package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Idioma;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.IdiomaRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/idioma-api")
public class IdiomaController {
	@Autowired
	private IdiomaRepository repo;
	
	@PostMapping("/salvar")
	public String salvar(@Valid Idioma idioma, BindingResult result) {
		if(result.hasErrors()) { return "codigo=06"; }
		
		if(idioma.getIdIdioma() != null) {
			Idioma existe = repo.findById(idioma.getIdIdioma()).orElse(new Idioma());
			
			if(!idioma.getDescricaoIdioma().isEmpty()) { existe.setDescricaoIdioma(idioma.getDescricaoIdioma()); }
			if(!idioma.getAlfabeto().isEmpty()) { existe.setAlfabeto(idioma.getAlfabeto()); }

			repo.save(existe);
			return "codigo=12";
		}else{
			repo.save(idioma);
			return "codigo=07";
		}
	}
	
	@PostMapping("/apagar")
	public String apagar(@RequestParam Integer id) {
		if(id != null) { repo.deleteById(id); }
		return "codigo=15";		//APAGOU
	}
}