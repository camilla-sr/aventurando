package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.TipoDano;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.DanoRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/tipodano-api")
public class TipoDanoController {
	@Autowired
	private DanoRepository repo;
	
	@PostMapping("/salvar")
	public String salvar(@Valid TipoDano dano, BindingResult result) {
		if(result.hasErrors()) { return "codigo=06"; }
		
		if(dano.getIdDano() != null) {
			TipoDano existe = repo.findById(dano.getIdDano()).orElse(new TipoDano());
			
			if(!dano.getDescricaoDano().isEmpty()) { existe.setDescricaoDano(dano.getDescricaoDano()); }

			repo.save(existe);
			return "codigo=12";
		}else{
			repo.save(dano);
			return "codigo=07";
		}
	}
	
	@PostMapping("/apagar")
	public String apagar(@RequestParam Integer id) {
		if(id != null) { repo.deleteById(id); }
		return "codigo=15";		//APAGOU
	}
}