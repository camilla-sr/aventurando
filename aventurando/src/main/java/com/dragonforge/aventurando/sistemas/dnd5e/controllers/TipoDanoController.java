package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.TipoDano;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.DanoRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/tipodano-api")
public class TipoDanoController {
	@Autowired private DanoRepository repo;
	
	@PostMapping
	public String salvar(@Valid TipoDano dano, BindingResult result, @RequestParam("url") String url) {
		if(result.hasErrors()) { return "redirect:" + url + "?codigo=06"; }
		
		if(dano.getId() != null) {
			TipoDano existe = repo.findById(dano.getId()).orElse(new TipoDano());
			
			if(!dano.getDescricaoDano().isEmpty()) { existe.setDescricaoDano(dano.getDescricaoDano()); }

			repo.save(existe);
			return "redirect:" + url + "?codigo=12";
		}else{
			repo.save(dano);
			return "redirect:" + url + "?codigo=07";
		}
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@RequestParam Integer id, @RequestParam("url") String url) {
		repo.deleteById(id);
		return "redirect:" + url + "?codigo=15";
	}
}