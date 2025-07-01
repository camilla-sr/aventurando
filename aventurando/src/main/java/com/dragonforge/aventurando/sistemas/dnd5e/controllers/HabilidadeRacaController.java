package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	@Autowired
	private HabRacaRepository repo;
	@Autowired
	private RacaRepository repoRaca;
	
	@PostMapping("/salvar")
	public String salvar(@Valid HabilidadeRaca habRaca, @RequestParam("raca") Integer raca, BindingResult result) {
		if(result.hasErrors()) { return "codigo=06"; }
	
		Raca racaSelect = repoRaca.findById(raca).orElseThrow();
		
		if(habRaca.getIdHabilidadeRaca() != null) {
			HabilidadeRaca existe = repo.findById(habRaca.getIdHabilidadeRaca()).orElse(new HabilidadeRaca());
			
			if(racaSelect != null) { existe.setRaca(racaSelect); }
			if(!habRaca.getNome().isEmpty()) { existe.setNome(habRaca.getNome()); }
			if(!habRaca.getDescricaoHabilidadeRaca().isEmpty()) { existe.setDescricaoHabilidadeRaca(habRaca.getDescricaoHabilidadeRaca()); }

			repo.save(existe);
			return "codigo=12";
		}else{
			repo.save(habRaca);
			return "codigo=07";
		}
	}
	
	@PostMapping("/apagar")
	public String apagar(@RequestParam Integer id) {
		if(id != null) { repo.deleteById(id); }
		return "codigo=15";		//APAGOU
	}
}