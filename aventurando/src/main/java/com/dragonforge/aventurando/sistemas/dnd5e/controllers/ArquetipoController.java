package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Arquetipo;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Classe;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.ArquetipoRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.ClasseRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("arquetipo-api")
public class ArquetipoController {
	@Autowired private ArquetipoRepository repo;
	@Autowired private ClasseRepository repoClass;
	
	@PostMapping
	public String salvar(@Valid Arquetipo arq, @RequestParam("classe") Integer classe, BindingResult result, @RequestParam("url") String url) {
		if(result.hasErrors()) { return "redirect:" + url + "?codigo=06"; }
		
		Classe classSelect = repoClass.findById(classe).orElseThrow();
		if(arq.getId() != null) {
			Arquetipo existe = repo.findById(arq.getId()).orElse(new Arquetipo());
			
			if(classSelect != null) { existe.setClasse(classSelect); }
			if(!arq.getTitulo().isEmpty()) { existe.setTitulo(arq.getTitulo()); }
			if(arq.getDescricaoArquetipo() != null) { existe.setDescricaoArquetipo(arq.getDescricaoArquetipo()); }
			
			repo.save(existe);
			return "redirect:" + url + "?codigo=12";
		}else{
			repo.save(arq);
			return "redirect:" + url + "?codigo=07";
		}
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@RequestParam Integer id, @RequestParam("url") String url) {
		repo.deleteById(id);
		return "redirect:" + url + "?codigo=15";
	}
}
