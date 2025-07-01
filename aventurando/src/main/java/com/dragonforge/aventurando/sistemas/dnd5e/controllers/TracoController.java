package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.TracoPersonalidade;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Antecedente;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.TracoRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.AntecedenteRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/traco-api")
public class TracoController {
	@Autowired
	private TracoRepository repo;
	@Autowired
	private AntecedenteRepository repoAntec;
	
	@PostMapping("/salvar")
	public String salvar(@Valid TracoPersonalidade traco, @RequestParam("antecedente") Integer antec, BindingResult result) {
		if(result.hasErrors()) { return "codigo=06"; }
	
		Antecedente antecSelect = repoAntec.findById(antec).orElseThrow();
		
		if(traco.getIdTraco() != null) {
			TracoPersonalidade existe = repo.findById(traco.getIdTraco()).orElse(new TracoPersonalidade());
			
			if(antecSelect != null) { existe.setAntecedente(antecSelect); }
			if(!traco.getDescricaoTraco().isEmpty()) { existe.setDescricaoTraco(traco.getDescricaoTraco()); }

			repo.save(existe);
			return "codigo=12";
		}else{
			repo.save(traco);
			return "codigo=07";
		}
	}
	
	@PostMapping("/apagar")
	public String apagar(@RequestParam Integer id) {
		if(id != null) { repo.deleteById(id); }
		return "codigo=15";		//APAGOU
	}
}