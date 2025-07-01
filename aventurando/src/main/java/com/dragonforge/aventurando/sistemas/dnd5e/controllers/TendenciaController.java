package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Tendencia;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.TendenciaRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/tendencia-api")
public class TendenciaController {
	@Autowired
	private TendenciaRepository repo;
	
	@PostMapping("/salvar")
	public String salvar(@Valid Tendencia tend, BindingResult result) {
		if(result.hasErrors()) { return "codigo=06"; }
	
		if(tend.getIdTendencia() != null) {
			Tendencia existe = repo.findById(tend.getIdTendencia()).orElse(new Tendencia());
			
			if(!tend.getTendencia().isEmpty()) { existe.setTendencia(tend.getTendencia()); }

			repo.save(existe);
			return "codigo=12";
		}else{
			repo.save(tend);
			return "codigo=07";
		}
	}
	
	@PostMapping("/apagar")
	public String apagar(@RequestParam Integer id) {
		if(id != null) { repo.deleteById(id); }
		return "codigo=15";		//APAGOU
	}
}