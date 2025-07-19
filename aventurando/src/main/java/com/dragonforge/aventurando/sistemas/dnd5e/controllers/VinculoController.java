package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	@Autowired private VinculoRepository repo;
	@Autowired private AntecedenteRepository repoAntec;
	
	@PostMapping
	public String salvar(@Valid Vinculo vinculo, @RequestParam("antecedente") Integer antec, BindingResult result, @RequestParam("url") String url) {
		if(result.hasErrors()) { return "redirect:" + url + "?codigo=06"; }
	
		Antecedente antecSelect = repoAntec.findById(antec).orElseThrow();
		
		if(vinculo.getIdVinculo() != null) {
			Vinculo existe = repo.findById(vinculo.getIdVinculo()).orElse(new Vinculo());
			
			if(antecSelect != null) { existe.setAntecedente(antecSelect); }
			if(!vinculo.getDescricaoVinculo().isEmpty()) { existe.setDescricaoVinculo(vinculo.getDescricaoVinculo()); }

			repo.save(existe);
			return "redirect:" + url + "?codigo=12";
		}else{
			repo.save(vinculo);
			return "redirect:" + url + "?codigo=07";
		}
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@RequestParam Integer id, @RequestParam("url") String url) {
		repo.deleteById(id);
		return "redirect:" + url + "?codigo=15";
	}
}