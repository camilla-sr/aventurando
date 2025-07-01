package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Raca;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.RacaRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/raca-api")
public class RacaController {
	@Autowired
	private RacaRepository repo;

	@PostMapping("/salvar")
	public String salvar(@Valid Raca raca, BindingResult result) {
		if(result.hasErrors()) { return "codigo=06"; }
	
		if(raca.getIdRaca() != null) {
			Raca existe = repo.findById(raca.getIdRaca()).orElse(new Raca());
			
			if(raca.getDeslocamento() != null) { existe.setDeslocamento(raca.getDeslocamento()); }
			if(!raca.getRaca().isEmpty()) { existe.setRaca(raca.getRaca()); }

			repo.save(existe);
			return "codigo=12";
		}else{
			repo.save(raca);
			return "codigo=07";
		}
	}
	
	@PostMapping("/apagar")
	public String apagar(@RequestParam Integer id) {
		if(id != null) { repo.deleteById(id); }
		return "codigo=15";		//APAGOU
	}
}