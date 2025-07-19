package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Equipamento;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Moeda;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.EquipamentoRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.MoedaRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/equipamento-api")
public class EquipamentoController {
	@Autowired private EquipamentoRepository repo;
	@Autowired private MoedaRepository repoCoin;
	
	@PostMapping
	public String salvar(@Valid Equipamento equip, @RequestParam("moeda") Integer moeda, BindingResult result, @RequestParam("url") String url) {
		if(result.hasErrors()) { return "redirect:" + url + "?codigo=06"; }
	
		Moeda moedaSelect = repoCoin.findById(moeda).orElseThrow();
		
		if(equip.getId() != null) {
			Equipamento existe = repo.findById(equip.getId()).orElse(new Equipamento());
			
			if(moedaSelect != null) { existe.setMoeda(moedaSelect); }
			if(!equip.getItem().isEmpty()) { existe.setItem(equip.getItem()); }
			if(equip.getPreco() != null) { existe.setPreco(equip.getPreco()); }
			if(equip.getPeso() != null) { existe.setPeso(equip.getPeso()); }
			
			repo.save(existe);
			return "redirect:" + url + "?codigo=12";
		}else{
			repo.save(equip);
			return "redirect:" + url + "?codigo=07";
		}
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@RequestParam Integer id, @RequestParam("url") String url) {
		repo.deleteById(id);
		return "redirect:" + url + "?codigo=15";
	}
}