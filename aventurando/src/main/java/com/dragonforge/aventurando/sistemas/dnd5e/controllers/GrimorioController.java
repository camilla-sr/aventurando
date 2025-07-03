package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Grimorio;
import com.dragonforge.aventurando.sistemas.dnd5e.models.HabilidadeMagia;
import com.dragonforge.aventurando.sistemas.dnd5e.models.GlossarioMagias;

import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.GrimorioRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.HabMagiaRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.GlossarioRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/grimorio-api")
public class GrimorioController {
	@Autowired
	private GrimorioRepository repo;
	@Autowired
	private HabMagiaRepository repoHab;
	@Autowired
	private GlossarioRepository repoMagic;
	
	@PostMapping("/salvar")
	public String salvar(@Valid Grimorio grim, @RequestParam("habmagia") Integer hab, @RequestParam("magia") Integer magic,
			 @RequestParam("idJogador") Integer player, BindingResult result) {
		if(result.hasErrors()) { return "codigo=06"; }

		HabilidadeMagia habSelect = repoHab.findById(hab).orElseThrow();
		GlossarioMagias magicSelect = repoMagic.findById(magic).orElseThrow();
		
		if(grim.getIdGrimorio() != null) {
			Grimorio existe = repo.findById(grim.getIdGrimorio()).orElse(new Grimorio());
			
			existe.setJogador(player);
			if(habSelect != null) { existe.setHabilidadeMagia(habSelect); }
			if(magicSelect != null) { existe.setMagia(magicSelect); }
			
			repo.save(existe);
			return "codigo=12";
		}else{
			repo.save(grim);
			return "codigo=07";
		}
	}
	
	@PostMapping("/apagar")
	public String apagar(@RequestParam Integer id) {
		if(id != null) { repo.deleteById(id); }
		return "codigo=15";		//APAGOU
	}
}