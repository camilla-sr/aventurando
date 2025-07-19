package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Moeda;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.MoedaRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/moeda-api")
public class MoedaController {
	@Autowired private MoedaRepository repo;
	
	@PostMapping
	public String salvar(@Valid Moeda moeda, BindingResult result, @RequestParam("url") String url) {
		if(result.hasErrors()) { return "redirect:" + url + "?codigo=06"; }
		
		if(moeda.getIdMoeda() != null) {
			Moeda existe = repo.findById(moeda.getIdMoeda()).orElse(new Moeda());
			
			if(!moeda.getMoeda().isEmpty()) { existe.setMoeda(moeda.getMoeda()); }
			if(moeda.getPeso() != null) { existe.setPeso(moeda.getPeso()); }

			repo.save(existe);
			return "redirect:" + url + "?codigo=12";
		}else{
			repo.save(moeda);
			return "redirect:" + url + "?codigo=07";
		}
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@RequestParam Integer id, @RequestParam("url") String url) {
		repo.deleteById(id);
		return "redirect:" + url + "?codigo=15";
	}
}