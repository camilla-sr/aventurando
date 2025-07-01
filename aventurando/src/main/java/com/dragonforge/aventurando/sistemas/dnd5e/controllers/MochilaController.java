package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Mochila;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Equipamento;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.MochilaRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.EquipamentoRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/mochila-api")
public class MochilaController {
	@Autowired
	private MochilaRepository repo;
	@Autowired
	private EquipamentoRepository repoEquip;
	
	@PostMapping("/salvar")
	public String salvar(@Valid Mochila bag, @RequestParam("equipamento") Integer equip, BindingResult result) {
		if(result.hasErrors()) { return "codigo=06"; }
	
		Equipamento equipSelect = repoEquip.findById(equip).orElseThrow();
		
		if(bag.getIdMochila() != null) {
			Mochila existe = repo.findById(bag.getIdMochila()).orElse(new Mochila());
			
			if(equipSelect != null) { existe.setItem(equipSelect); }
			if(bag.getQuantidade() != null) { existe.setQuantidade(bag.getQuantidade()); }

			repo.save(existe);
			return "codigo=12";
		}else{
			repo.save(bag);
			return "codigo=07";
		}
	}
	
	@PostMapping("/apagar")
	public String apagar(@RequestParam Integer id) {
		if(id != null) { repo.deleteById(id); }
		return "codigo=15";		//APAGOU
	}
}