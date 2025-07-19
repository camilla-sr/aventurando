package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Arma;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Arsenal;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.ArmaRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.ArsenalRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/arsenal-api")
public class ArsenalController {
	@Autowired private ArsenalRepository repo;
	@Autowired private ArmaRepository repoArma;
	
	@PostMapping
	public String salvar(@Valid Arsenal arse, @RequestParam("arma") Integer arma, BindingResult result, @RequestParam("url") String url) {
		if(result.hasErrors()) { return "redirect:" + url + "?codigo=06"; }
		
		Arma armaSelect = repoArma.findById(arma).orElseThrow();
		if(arse.getId() != null) {
			Arsenal existe = repo.findById(arse.getId()).orElse(new Arsenal());
			
			if(armaSelect != null) {
				existe.setArma(armaSelect);
			}
			if(arse.getQuantidade() != null) { existe.setQuantidade(arse.getQuantidade()); }
			repo.save(existe);
			return "redirect:" + url + "?codigo=12";
		}else{
			repo.save(arse);
			return "redirect:" + url + "?codigo=07";
		}
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@RequestParam Integer id, @RequestParam("url") String url) {
		repo.deleteById(id);
		return "redirect:" + url + "?codigo=15";
	}
}
