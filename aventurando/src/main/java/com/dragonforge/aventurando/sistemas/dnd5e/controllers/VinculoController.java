package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Vinculo;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Antecedente;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.VinculoRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.AntecedenteRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/vinculo-api")
public class VinculoController {
	@Autowired
	private VinculoRepository repo;
	@Autowired
	private AntecedenteRepository repoAntec;
	
	@PostMapping("/salvar")
	public String salvar(@Valid Vinculo vinculo, @RequestParam("antecedente") Integer antec, BindingResult result) {
		if(result.hasErrors()) { return "codigo=06"; }
	
		Antecedente antecSelect = repoAntec.findById(antec).orElseThrow();
		
		if(vinculo.getIdVinculo() != null) {
			Vinculo existe = repo.findById(vinculo.getIdVinculo()).orElse(new Vinculo());
			
			if(antecSelect != null) { existe.setAntecedente(antecSelect); }
			if(!vinculo.getDescricaoVinculo().isEmpty()) { existe.setDescricaoVinculo(vinculo.getDescricaoVinculo()); }

			repo.save(existe);
			return "codigo=12";
		}else{
			repo.save(vinculo);
			return "codigo=07";
		}
	}
	
	@PostMapping("/apagar")
	public String apagar(@RequestParam Integer id) {
		if(id != null) { repo.deleteById(id); }
		return "codigo=15";		//APAGOU
	}
}