package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Ideal;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Antecedente;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.IdealRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.AntecedenteRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/ideal-api")
public class IdealController {
	@Autowired private IdealRepository repo;
	@Autowired private AntecedenteRepository repoAntec;
	
	@PostMapping
	public String salvar(@Valid Ideal ideal, @RequestParam("antecedente") Integer antec, BindingResult result, @RequestParam("url") String url) {
		if(result.hasErrors()) { return "redirect:" + url + "?codigo=06"; }
	
		Antecedente antecSelect = repoAntec.findById(antec).orElseThrow();
		
		if(ideal.getIdIdeal() != null) {
			Ideal existe = repo.findById(ideal.getIdIdeal()).orElse(new Ideal());
			
			if(antecSelect != null) { existe.setAntecedente(antecSelect); }
			if(!ideal.getDescricaoIdeal().isEmpty()) { existe.setDescricaoIdeal(ideal.getDescricaoIdeal()); }

			repo.save(existe);
			return "redirect:" + url + "?codigo=12";
		}else{
			repo.save(ideal);
			return "redirect:" + url + "?codigo=07";
		}
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@RequestParam Integer id, @RequestParam("url") String url) {
		repo.deleteById(id);
		return "redirect:" + url + "?codigo=15";
	}
}