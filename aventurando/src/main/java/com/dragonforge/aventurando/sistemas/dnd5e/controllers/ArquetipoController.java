package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	@Autowired
	private ArquetipoRepository repo;
	@Autowired
	private ClasseRepository repoClass;
	
	@PostMapping("/salvar")
	public String salvar(@Valid Arquetipo arq, @RequestParam("classe") Integer classe, BindingResult result) {
		if(result.hasErrors()) { return "codigo=06"; }		//DEU ERRO EM ALGUMA COISA
		
		Classe classSelect = repoClass.findById(classe).orElseThrow();
		if(arq.getIdArquetipo() != null) {
			Arquetipo existe = repo.findById(arq.getIdArquetipo()).orElse(new Arquetipo());
			
			if(classSelect != null) { existe.setClasse(classSelect); }
			if(!arq.getTitulo().isEmpty()) { existe.setTitulo(arq.getTitulo()); }
			if(arq.getDescricaoArquetipo() != null) { existe.setDescricaoArquetipo(arq.getDescricaoArquetipo()); }
			
			repo.save(existe);
			return "codigo=12";		//EDITADO
		}else{
			repo.save(arq);
			return "codigo=07";		//CADASTROU
		}
	}
	
	@PostMapping("/apagar")
	public String apagar(@RequestParam Integer id) {
		if(id != null) { repo.deleteById(id); }
		return "codigo=15";		//APAGOU
	}
}
