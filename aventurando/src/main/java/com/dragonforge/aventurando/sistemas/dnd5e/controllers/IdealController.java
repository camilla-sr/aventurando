package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	@Autowired
	private IdealRepository repo;
	@Autowired
	private AntecedenteRepository repoAntec;
	
	@PostMapping("/salvar")
	public String salvar(@Valid Ideal ideal, @RequestParam("antecedente") Integer antec, BindingResult result) {
		if(result.hasErrors()) { return "codigo=06"; }
	
		Antecedente antecSelect = repoAntec.findById(antec).orElseThrow();
		
		if(ideal.getIdIdeal() != null) {
			Ideal existe = repo.findById(ideal.getIdIdeal()).orElse(new Ideal());
			
			if(antecSelect != null) { existe.setAntecedente(antecSelect); }
			if(!ideal.getDescricaoIdeal().isEmpty()) { existe.setDescricaoIdeal(ideal.getDescricaoIdeal()); }

			repo.save(existe);
			return "codigo=12";
		}else{
			repo.save(ideal);
			return "codigo=07";
		}
	}
	
	@PostMapping("/apagar")
	public String apagar(@RequestParam Integer id) {
		if(id != null) { repo.deleteById(id); }
		return "codigo=15";		//APAGOU
	}
}