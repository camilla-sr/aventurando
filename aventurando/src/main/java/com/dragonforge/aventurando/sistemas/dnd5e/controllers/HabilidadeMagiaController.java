package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.HabilidadeMagia;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.HabMagiaRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/habilidademagia-api")
public class HabilidadeMagiaController {
	@Autowired
	private HabMagiaRepository repo;
	
	@PostMapping("/salvar")
	public String salvar(@Valid HabilidadeMagia habMagic, BindingResult result) {
		if(result.hasErrors()) { return "codigo=06"; }
		
		if(habMagic.getIdHabilidade() != null) {
			HabilidadeMagia existe = repo.findById(habMagic.getIdHabilidade()).orElse(new HabilidadeMagia());
			
			if(!habMagic.getHabilidadeChave().isEmpty()) { existe.setHabilidadeChave(habMagic.getHabilidadeChave()) ;}

			repo.save(existe);
			return "codigo=12";
		}else{
			repo.save(habMagic);
			return "codigo=07";
		}
	}
	
	@PostMapping("/apagar")
	public String apagar(@RequestParam Integer id) {
		if(id != null) { repo.deleteById(id); }
		return "codigo=15";		//APAGOU
	}
}
