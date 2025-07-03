package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Inventario;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Deposito;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Arsenal;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Mochila;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Utilitarios;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Tranqueiras;

import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.InventarioRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.DepositoRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.ArsenalRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.MochilaRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.UtilitariosRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.TranqueirasRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/inventario-api")
public class InventarioController {
	@Autowired
	private InventarioRepository repo;
	@Autowired
	private DepositoRepository repoDep;
	@Autowired
	private ArsenalRepository repoArs;
	@Autowired
	private MochilaRepository repoBag;
	@Autowired
	private UtilitariosRepository repoUtil;
	@Autowired
	private TranqueirasRepository repoTranq;
	
	@PostMapping("/salvar")
	public String salvar(@Valid Inventario inventario, @RequestParam("armaduras") Integer dep, @RequestParam("armas") Integer ars,
			 @RequestParam("equipamentos") Integer bag, @RequestParam("ferramentas") Integer util, @RequestParam("bugigangas") Integer tranq,
			 @RequestParam("idJogador") Integer player, BindingResult result) {
		if(result.hasErrors()) { return "codigo=06"; }

		Deposito depoSelect = repoDep.findById(dep).orElseThrow();
		Arsenal arsSelect = repoArs.findById(ars).orElseThrow();
		Mochila bagSelect = repoBag.findById(bag).orElseThrow();
		Utilitarios utilSelect = repoUtil.findById(util).orElseThrow();
		Tranqueiras tranqSelect = repoTranq.findById(tranq).orElseThrow();
		
		if(inventario.getIdInventario() != null) {
			Inventario existe = repo.findById(inventario.getIdInventario()).orElse(new Inventario());
			
			existe.setJogador(player);
			if(depoSelect != null) { existe.setDeposito(depoSelect); }
			if(arsSelect != null) { existe.setArsenal(arsSelect); }
			if(bagSelect != null) { existe.setMochila(bagSelect); }
			if(utilSelect != null) { existe.setUtilitarios(utilSelect); }
			if(tranqSelect != null) { existe.setTranqueiras(tranqSelect); }
			if(inventario.getCobre() != null) { existe.setCobre(inventario.getCobre()); }
			if(inventario.getPrata() != null) { existe.setPrata(inventario.getPrata()); }
			if(inventario.getElectro() != null) { existe.setElectro(inventario.getElectro()); }
			if(inventario.getOuro() != null) { existe.setOuro(inventario.getOuro()); }
			if(inventario.getPlatina() != null) { existe.setPlatina(inventario.getPlatina()); }
			
			repo.save(existe);
			return "codigo=12";
		}else{
			repo.save(inventario);
			return "codigo=07";
		}
	}
	
	@PostMapping("/apagar")
	public String apagar(@RequestParam Integer id) {
		if(id != null) { repo.deleteById(id); }
		return "codigo=15";		//APAGOU
	}
}