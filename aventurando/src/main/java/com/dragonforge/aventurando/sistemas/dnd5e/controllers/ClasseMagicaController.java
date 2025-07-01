package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Classe;
import com.dragonforge.aventurando.sistemas.dnd5e.models.ClasseMagica;
import com.dragonforge.aventurando.sistemas.dnd5e.models.GlossarioMagias;
import com.dragonforge.aventurando.sistemas.dnd5e.models.HabilidadeMagia;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.ClasseMagicaRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.ClasseRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.GlossarioRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.HabMagiaRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/classemagica-api")
public class ClasseMagicaController {
	@Autowired
	private ClasseMagicaRepository repo;
	@Autowired
	private ClasseRepository repoClass;
	@Autowired
	private GlossarioRepository repoGloss;
	@Autowired
	private HabMagiaRepository repoHab;
	
	@PostMapping("/salvar")
	public String salvar(@Valid ClasseMagica cMagica, @RequestParam("classe") Integer classe,
						@RequestParam("magia") Integer magia, @RequestParam("habilidade") Integer hab,BindingResult result) {
		if(result.hasErrors()) { return "codigo=06"; }
	
		Classe classeSelect = repoClass.findById(classe).orElseThrow();
		GlossarioMagias magiaSelect = repoGloss.findById(magia).orElseThrow();
		HabilidadeMagia habSelect = repoHab.findById(hab).orElseThrow();
		
		if(cMagica.getIdLigacao() != null) {
			ClasseMagica existe = repo.findById(cMagica.getIdLigacao()).orElse(new ClasseMagica());
			
			if(classeSelect != null) { existe.setClasse(classeSelect); }
			if(magiaSelect != null) { existe.setMagia(magiaSelect); }
			if(habSelect != null) { existe.setHabilidade(habSelect); }
			
			repo.save(existe);
			return "codigo=12";
		}else{
			repo.save(cMagica);
			return "codigo=07";
		}
	}
	
	@PostMapping("/apagar")
	public String apagar(@RequestParam Integer id) {
		if(id != null) { repo.deleteById(id); }
		return "codigo=15";		//APAGOU
	}
}
