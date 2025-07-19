package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Tendencia;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.TendenciaRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/tendencia-api")
public class TendenciaController {
	@Autowired private TendenciaRepository repo;
	
	@PostMapping
	public String salvar(@Valid Tendencia tend, BindingResult result, @RequestParam("url") String url) {
		if(result.hasErrors()) { return "redirect:" + url + "?codigo=06"; }
	
		if(tend.getIdTendencia() != null) {
			Tendencia existe = repo.findById(tend.getIdTendencia()).orElse(new Tendencia());
			
			if(!tend.getTendencia().isEmpty()) { existe.setTendencia(tend.getTendencia()); }

			repo.save(existe);
			return "redirect:" + url + "?codigo=12";
		}else{
			repo.save(tend);
			return "redirect:" + url + "?codigo=07";
		}
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@RequestParam Integer id, @RequestParam("url") String url) {
		repo.deleteById(id);
		return "redirect:" + url + "?codigo=15";
	}
}