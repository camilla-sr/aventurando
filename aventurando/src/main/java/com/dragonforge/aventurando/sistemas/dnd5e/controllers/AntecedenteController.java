package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Antecedente;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.AntecedenteRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/antecedente-api")
public class AntecedenteController {
	@Autowired
	private AntecedenteRepository repo;
	
	@PostMapping(value = "/salvar")
	public String salvar(@Valid Antecedente antec, BindingResult result) {
		if(result.hasErrors()) { return "codigo=06"; }		//DEU ERRO EM ALGUMA COISA
		
		if(antec.getIdAntecedente() != null) {
			Antecedente existe = repo.findById(antec.getIdAntecedente()).orElse(new Antecedente());
			if(!antec.getAntecedente().isEmpty()) { existe.setAntecedente(antec.getAntecedente()); }
			
			repo.save(existe);
			return "codigo=12";		//EDITADO
		}else{
			repo.save(antec);
			return "codigo=07";		//CADASTROU
		}
	}
	
	@PostMapping(value = "/apagar")
	public String apagar(@RequestParam Integer idAntecedente) {
		if(idAntecedente != null) {
			repo.deleteById(idAntecedente);
		}
		return "codigo=15";		//APAGOU
	}
}
