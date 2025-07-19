package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Raca;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.RacaRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/raca-api")
public class RacaController {
	@Autowired private RacaRepository repo;

	@PostMapping
	public String salvar(@Valid Raca raca, BindingResult result, @RequestParam("url") String url) {
		if(result.hasErrors()) { return "redirect:" + url + "?codigo=06"; }
	
		if(raca.getIdRaca() != null) {
			Raca existe = repo.findById(raca.getIdRaca()).orElse(new Raca());
			
			if(raca.getDeslocamento() != null) { existe.setDeslocamento(raca.getDeslocamento()); }
			if(!raca.getRaca().isEmpty()) { existe.setRaca(raca.getRaca()); }

			repo.save(existe);
			return "redirect:" + url + "?codigo=12";
		}else{
			repo.save(raca);
			return "redirect:" + url + "?codigo=07";
		}
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@RequestParam Integer id, @RequestParam("url") String url) {
		repo.deleteById(id);
		return "redirect:" + url + "?codigo=15";
	}
}