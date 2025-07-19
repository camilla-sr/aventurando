package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Raca;
import com.dragonforge.aventurando.sistemas.dnd5e.models.HabilidadeRaca;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.RacaRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.HabRacaRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/habilidaderaca-api")
public class HabilidadeRacaController {
	@Autowired private HabRacaRepository repo;
	@Autowired private RacaRepository repoRaca;
	
	@PostMapping
	public String salvar(@Valid HabilidadeRaca habRaca, @RequestParam("raca") Integer raca, BindingResult result, @RequestParam("url") String url) {
		if(result.hasErrors()) { return "redirect:" + url + "?codigo=06"; }
	
		Raca racaSelect = repoRaca.findById(raca).orElseThrow();
		
		if(habRaca.getId() != null) {
			HabilidadeRaca existe = repo.findById(habRaca.getId()).orElse(new HabilidadeRaca());
			
			if(racaSelect != null) { existe.setRaca(racaSelect); }
			if(!habRaca.getNome().isEmpty()) { existe.setNome(habRaca.getNome()); }
			if(!habRaca.getDescricaoHabilidadeRaca().isEmpty()) { existe.setDescricaoHabilidadeRaca(habRaca.getDescricaoHabilidadeRaca()); }

			repo.save(existe);
			return "redirect:" + url + "?codigo=12";
		}else{
			repo.save(habRaca);
			return "redirect:" + url + "?codigo=07";
		}
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@RequestParam Integer id, @RequestParam("url") String url) {
		repo.deleteById(id);
		return "redirect:" + url + "?codigo=15";
	}
}