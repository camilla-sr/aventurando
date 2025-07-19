package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Dado;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.DadoRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/dado-api")
public class DadoController {
	@Autowired private DadoRepository repo;
	
	@PostMapping
	public String salvar(@Valid Dado dado, BindingResult result, @RequestParam("url") String url) {
		if(result.hasErrors()) { return "redirect:" + url + "?codigo=06"; }
		
		if(dado.getId() != null) {
			Dado existe = repo.findById(dado.getId()).orElse(new Dado());
			
			if(!dado.getTipo().isEmpty()) { existe.setTipo(dado.getTipo()); }
			
			repo.save(existe);
			return "redirect:" + url + "?codigo=12";
		}else{
			repo.save(dado);
			return "redirect:" + url + "?codigo=07";
		}
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@RequestParam Integer id, @RequestParam("url") String url) {
		repo.deleteById(id);
		return "redirect:" + url + "?codigo=15";
	}
}
