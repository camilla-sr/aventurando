package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Classe;
import com.dragonforge.aventurando.sistemas.dnd5e.models.HabilidadeClasse;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.ClasseRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.HabClasseRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/habilidadeclasse-api")
public class HabilidadeClasseController {
	@Autowired
	private HabClasseRepository repo;
	@Autowired
	private ClasseRepository repoClass;
	
	@PostMapping("/salvar")
	public String salvar(@Valid HabilidadeClasse habClass, @RequestParam("classe") Integer classe, BindingResult result) {
		if(result.hasErrors()) { return "codigo=06"; }
	
		Classe classeSelect = repoClass.findById(classe).orElseThrow();
		
		if(habClass.getIdHabilidadeClasse() != null) {
			HabilidadeClasse existe = repo.findById(habClass.getIdHabilidadeClasse()).orElse(new HabilidadeClasse());
			
			if(classeSelect != null) { existe.setClasse(classeSelect); }
			if(!habClass.getNome().isEmpty()) { existe.setNome(habClass.getNome()); }
			if(!habClass.getDescricaoHabilidadeClasse().isEmpty()) { existe.setDescricaoHabilidadeClasse(habClass.getDescricaoHabilidadeClasse()); }

			repo.save(existe);
			return "codigo=12";
		}else{
			repo.save(habClass);
			return "codigo=07";
		}
	}
	
	@PostMapping("/apagar")
	public String apagar(@RequestParam Integer id) {
		if(id != null) { repo.deleteById(id); }
		return "codigo=15";		//APAGOU
	}
}
