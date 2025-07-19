package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Antecedente;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.AntecedenteRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/antecedente-api")
public class AntecedenteController {
	@Autowired private AntecedenteRepository repo;
	
	@PostMapping
	public String salvar(@Valid Antecedente antec, @RequestParam("url") String url, BindingResult result) {
		if(result.hasErrors()) { return "redirect:" + url + "?codigo=06"; }		//DEU ERRO EM ALGUMA COISA
		
		if(antec.getId() != null) {
			Antecedente existe = repo.findById(antec.getId()).orElse(new Antecedente());
			if(!antec.getAntecedente().isEmpty()) { existe.setAntecedente(antec.getAntecedente()); }
			
			repo.save(existe);
			return "redirect:" + url + "?codigo=12";		//EDITADO
		}else{
			repo.save(antec);
			return "redirect:" + url + "?codigo=07";		//CADASTROU
		}
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@PathVariable("id") Integer id, @RequestParam("url") String url) {
		repo.deleteById(id);
		return "redirect:" + url + "?codigo=15";		//APAGOU
	}
}