package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	@Autowired private FerramentaRepository repo;
	@Autowired private MoedaRepository repoCoin;
	
	@PostMapping
	public String salvar(@Valid Ferramenta tool, @RequestParam("moeda") Integer moeda, BindingResult result, @RequestParam("url") String url) {
		if(result.hasErrors()) { return "redirect:" + url + "?codigo=06"; }
	
		Moeda moedaSelect = repoCoin.findById(moeda).orElseThrow();
		
		if(tool.getId() != null) {
			Ferramenta existe = repo.findById(tool.getId()).orElse(new Ferramenta());
			
			if(moedaSelect != null) { existe.setMoeda(moedaSelect); }
			if(!tool.getFerramenta().isEmpty()) { existe.setFerramenta(tool.getFerramenta()); }
			if(tool.getPreco() != null) { existe.setPreco(tool.getPreco()); }
			if(tool.getPeso() != null) { existe.setPeso(tool.getPeso()); }
			
			repo.save(existe);
			return "redirect:" + url + "?codigo=12";
		}else{
			repo.save(tool);
			return "redirect:" + url + "?codigo=07";
		}
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@RequestParam Integer id, @RequestParam("url") String url) {
		repo.deleteById(id);
		return "redirect:" + url + "?codigo=15";
	}
}