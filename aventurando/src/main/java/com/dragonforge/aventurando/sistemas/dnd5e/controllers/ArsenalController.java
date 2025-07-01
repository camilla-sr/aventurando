package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	@Autowired
	private ArsenalRepository repo;
	@Autowired
	private ArmaRepository repoArma;
	
	@PostMapping("/salvar")
	public String salvar(@Valid Arsenal arse, @RequestParam("arma") Integer arma, BindingResult result) {
		if(result.hasErrors()) { return "codigo=06"; }		//DEU ERRO EM ALGUMA COISA
		
		Arma armaSelect = repoArma.findById(arma).orElseThrow();
		if(arse.getIdArsenal() != null) {
			Arsenal existe = repo.findById(arse.getIdArsenal()).orElse(new Arsenal());
			
			if(armaSelect != null) {
				existe.setArma(armaSelect);
			}
			if(arse.getQuantidade() != null) { existe.setQuantidade(arse.getQuantidade()); }
			repo.save(existe);
			return "codigo=12";		//EDITADO
		}else{
			repo.save(arse);
			return "codigo=07";		//CADASTROU
		}
	}
	
	@PostMapping("/apagar")
	public String apagar(@RequestParam Integer id) {
		if(id != null) { repo.deleteById(id); }
		return "codigo=15";		//APAGOU
	}
}
