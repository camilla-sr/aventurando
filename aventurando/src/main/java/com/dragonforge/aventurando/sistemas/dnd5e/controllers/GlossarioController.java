package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.GlossarioMagias;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.GlossarioRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/glossario-api")
public class GlossarioController {
	@Autowired private GlossarioRepository repo;
	
	@PostMapping
	public String salvar(@Valid GlossarioMagias magia, BindingResult result, @RequestParam("url") String url) {
		if(result.hasErrors()) { return "redirect:" + url + "?codigo=06"; }
	
		if(magia.getIdMagia() != null) {
			GlossarioMagias existe = repo.findById(magia.getIdMagia()).orElse(new GlossarioMagias());
			
			if(!magia.getMagia().isEmpty()) { existe.setMagia(magia.getMagia()); }
			if(magia.getNivel() != null) { existe.setNivel(magia.getNivel()); }
			if(!magia.getDescricaoMagia().isEmpty()) { existe.setDescricaoMagia(magia.getDescricaoMagia()); }
			
			repo.save(existe);
			return "redirect:" + url + "?codigo=12";
		}else{
			repo.save(magia);
			return "redirect:" + url + "?codigo=07";
		}
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@RequestParam Integer id, @RequestParam("url") String url) {
		repo.deleteById(id);
		return "redirect:" + url + "?codigo=15";
	}
}