package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Armadura;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Moeda;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.ArmaduraRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.MoedaRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/armadura-api")
public class ArmaduraController {
	@Autowired private ArmaduraRepository repo;
	@Autowired private MoedaRepository repoCoin;
	
	@PostMapping
	public String salvar(@Valid Armadura armor, @RequestParam("idMoeda") Integer idMoeda, BindingResult result, @RequestParam("url") String url) {
		if(result.hasErrors()) { return "redirect:" + url + "?codigo=06"; }		//DEU ERRO EM ALGUMA COISA
		
		Moeda moedaSelect = repoCoin.findById(idMoeda).orElseThrow();
		if(armor.getId() != null) {
			Armadura existe = repo.findById(armor.getId()).orElse(new Armadura());
			
			if(moedaSelect != null) { existe.setMoeda(moedaSelect); }
			if(!armor.getTipo().isEmpty()) { existe.setTipo(armor.getTipo()); }
			if(armor.getPreco() != null) { existe.setPreco(armor.getPreco()); }
			if(armor.getClasseArmadura() != null) { existe.setClasseArmadura(armor.getClasseArmadura()); }
			if(!armor.getModificador().isEmpty()) { existe.setModificador(armor.getModificador()); }
			if(!armor.getRequisito().isEmpty()) { existe.setRequisito(armor.getRequisito()); }
			if(!armor.getDesvantagem().isEmpty()) { existe.setDesvantagem(armor.getDesvantagem()); }
			if(armor.getPeso() != null) { existe.setPeso(armor.getPeso()); }
			
			repo.save(existe);
			return "redirect:" + url + "?codigo=12";		//EDITADO
		}else{
			repo.save(armor);
			return "redirect:" + url + "?codigo=07";		//CADASTROU
		}
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@RequestParam Integer id, @RequestParam("url") String url) {
		repo.deleteById(id);
		return "redirect:" + url + "?codigo=15";		//APAGOU
	}
}
