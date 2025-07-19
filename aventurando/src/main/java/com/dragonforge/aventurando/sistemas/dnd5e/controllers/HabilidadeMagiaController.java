package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.HabilidadeMagia;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.HabMagiaRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/habilidademagia-api")
public class HabilidadeMagiaController {
	@Autowired private HabMagiaRepository repo;
	
	@PostMapping
	public String salvar(@Valid HabilidadeMagia habMagic, BindingResult result, @RequestParam("url") String url) {
		if(result.hasErrors()) { return "redirect:" + url + "?codigo=06"; }
		
		if(habMagic.getIdHabilidade() != null) {
			HabilidadeMagia existe = repo.findById(habMagic.getIdHabilidade()).orElse(new HabilidadeMagia());
			
			if(!habMagic.getHabilidadeChave().isEmpty()) { existe.setHabilidadeChave(habMagic.getHabilidadeChave()) ;}

			repo.save(existe);
			return "redirect:" + url + "?codigo=12";
		}else{
			repo.save(habMagic);
			return "redirect:" + url + "?codigo=07";
		}
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@RequestParam Integer id, @RequestParam("url") String url) {
		repo.deleteById(id);
		return "redirect:" + url + "?codigo=15";
	}
}