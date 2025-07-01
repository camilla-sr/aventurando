package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	@Autowired
	private DefeitoRepository repo;
	@Autowired
	private AntecedenteRepository repoAntec;
	
	@PostMapping("/salvar")
	public String salvar(@Valid Defeito def, @RequestParam("antecedente") Integer antec, BindingResult result) {
		if(result.hasErrors()) { return "codigo=06"; }
	
		Antecedente antecSelect = repoAntec.findById(antec).orElseThrow();
		
		if(def.getIdDefeito() != null) {
			Defeito existe = repo.findById(def.getIdDefeito()).orElse(new Defeito());
			
			if(antecSelect != null) { existe.setAntecedente(antecSelect); }
			if(!def.getDescricaoDefeito().isEmpty()) { existe.setDescricaoDefeito(def.getDescricaoDefeito()); }
			
			repo.save(existe);
			return "codigo=12";
		}else{
			repo.save(def);
			return "codigo=07";
		}
	}
	
	@PostMapping("/apagar")
	public String apagar(@RequestParam Integer id) {
		if(id != null) { repo.deleteById(id); }
		return "codigo=15";		//APAGOU
	}
}