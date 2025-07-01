package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Ferramenta;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Moeda;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.FerramentaRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.MoedaRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/ferramenta-api")
public class FerramentaController {
	@Autowired
	private FerramentaRepository repo;
	@Autowired
	private MoedaRepository repoCoin;
	
	@PostMapping("/salvar")
	public String salvar(@Valid Ferramenta tool, @RequestParam("moeda") Integer moeda, BindingResult result) {
		if(result.hasErrors()) { return "codigo=06"; }
	
		Moeda moedaSelect = repoCoin.findById(moeda).orElseThrow();
		
		if(tool.getIdFerramenta() != null) {
			Ferramenta existe = repo.findById(tool.getIdFerramenta()).orElse(new Ferramenta());
			
			if(moedaSelect != null) { existe.setMoeda(moedaSelect); }
			if(!tool.getFerramenta().isEmpty()) { existe.setFerramenta(tool.getFerramenta()); }
			if(tool.getPreco() != null) { existe.setPreco(tool.getPreco()); }
			if(tool.getPeso() != null) { existe.setPeso(tool.getPeso()); }
			
			repo.save(existe);
			return "codigo=12";
		}else{
			repo.save(tool);
			return "codigo=07";
		}
	}
	
	@PostMapping("/apagar")
	public String apagar(@RequestParam Integer id) {
		if(id != null) { repo.deleteById(id); }
		return "codigo=15";		//APAGOU
	}
}
