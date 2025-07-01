package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Armadura;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Deposito;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.ArmaduraRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.DepositoRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/deposito-api")
public class DepositoController {
	@Autowired
	private DepositoRepository repo;
	@Autowired
	private ArmaduraRepository repoArmor;
	
	@PostMapping("/salvar")
	public String salvar(@Valid Deposito depo, @RequestParam("armadura") Integer armor, BindingResult result) {
		if(result.hasErrors()) { return "codigo=06"; }
	
		Armadura armorSelect = repoArmor.findById(armor).orElseThrow();
		
		if(depo.getIdDeposito() != null) {
			Deposito existe = repo.findById(depo.getIdDeposito()).orElse(new Deposito());
			
			if(armorSelect != null) { existe.setArmadura(armorSelect); }
			if(depo.getQuantidade() != null) { existe.setQuantidade(depo.getQuantidade()); }
			
			repo.save(existe);
			return "codigo=12";
		}else{
			repo.save(depo);
			return "codigo=07";
		}
	}
	
	@PostMapping("/apagar")
	public String apagar(@RequestParam Integer id) {
		if(id != null) { repo.deleteById(id); }
		return "codigo=15";		//APAGOU
	}
}