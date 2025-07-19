package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	@Autowired private HabClasseRepository repo;
	@Autowired private ClasseRepository repoClass;
	
	@PostMapping
	public String salvar(@Valid HabilidadeClasse habClass, @RequestParam("classe") Integer classe, BindingResult result, @RequestParam("url") String url) {
		if(result.hasErrors()) { return "redirect:" + url + "?codigo=06"; }
	
		Classe classeSelect = repoClass.findById(classe).orElseThrow();
		
		if(habClass.getIdHabilidadeClasse() != null) {
			HabilidadeClasse existe = repo.findById(habClass.getIdHabilidadeClasse()).orElse(new HabilidadeClasse());
			
			if(classeSelect != null) { existe.setClasse(classeSelect); }
			if(!habClass.getNome().isEmpty()) { existe.setNome(habClass.getNome()); }
			if(!habClass.getDescricaoHabilidadeClasse().isEmpty()) { existe.setDescricaoHabilidadeClasse(habClass.getDescricaoHabilidadeClasse()); }

			repo.save(existe);
			return "redirect:" + url + "?codigo=12";
		}else{
			repo.save(habClass);
			return "redirect:" + url + "?codigo=07";
		}
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@RequestParam Integer id, @RequestParam("url") String url) {
		repo.deleteById(id);
		return "redirect:" + url + "?codigo=15";
	}
}