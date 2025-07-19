package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Antecedente;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Defeito;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.AntecedenteRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.DefeitoRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/defeito-api")
public class DefeitoController {
	@Autowired private DefeitoRepository repo;
	@Autowired private AntecedenteRepository repoAntec;
	
	@PostMapping
	public String salvar(@Valid Defeito def, @RequestParam("antecedente") Integer antec, BindingResult result, @RequestParam("url") String url) {
		if(result.hasErrors()) { return "redirect:" + url + "?codigo=06"; }
	
		Antecedente antecSelect = repoAntec.findById(antec).orElseThrow();
		
		if(def.getId() != null) {
			Defeito existe = repo.findById(def.getId()).orElse(new Defeito());
			
			if(antecSelect != null) { existe.setAntecedente(antecSelect); }
			if(!def.getDescricaoDefeito().isEmpty()) { existe.setDescricaoDefeito(def.getDescricaoDefeito()); }
			
			repo.save(existe);
			return "redirect:" + url + "?codigo=12";
		}else{
			repo.save(def);
			return "redirect:" + url + "?codigo=07";
		}
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@RequestParam Integer id, @RequestParam("url") String url) {
		repo.deleteById(id);
		return "redirect:" + url + "?codigo=15";
	}
}