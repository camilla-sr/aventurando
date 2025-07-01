package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Classe;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Dado;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.ClasseRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.DadoRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/classe-api")
public class ClasseController {
	@Autowired
	private ClasseRepository repo;
	@Autowired
	private DadoRepository repoDado;
	
	@PostMapping("/salvar")
	public String salvar(@Valid Classe classe, @RequestParam("dadoVida") Integer dadoVida ,BindingResult result) {
		if(result.hasErrors()) { return "codigo=06"; }
	
		Dado dadoSelect = repoDado.findById(dadoVida).orElseThrow();
		if(classe.getIdClasse() != null) {
			Classe existe = repo.findById(classe.getIdClasse()).orElse(new Classe());
			
			if(dadoSelect != null) { existe.setDadoVida(dadoSelect); }
			if(!classe.getClasse().isEmpty()) { existe.setClasse(classe.getClasse()); }
			if(!classe.getDescricaoClasse().isEmpty()) { existe.setDescricaoClasse(classe.getDescricaoClasse()); }
			if(!classe.getHabilidadePrimaria().isEmpty()) { existe.setHabilidadePrimaria(classe.getHabilidadePrimaria()); }
			if(!classe.getpArmasArmaduras().isEmpty()) { existe.setpArmasArmaduras(classe.getpArmasArmaduras()); }
			if(!classe.getpTesteResistencia().isEmpty()) { existe.setpTesteResistencia(classe.getpTesteResistencia()); }
				
			repo.save(existe);
			return "codigo=12";
		}else{
			repo.save(classe);
			return "codigo=07";
		}
	}
	
	@PostMapping("/apagar")
	public String apagar(@RequestParam Integer id) {
		if(id != null) { repo.deleteById(id); }
		return "codigo=15";		//APAGOU
	}
}