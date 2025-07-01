package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Talento;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.TalentoRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/talento-api")
public class TalentoController {
	@Autowired
	private TalentoRepository repo;
	
	@PostMapping("/salvar")
	public String salvar(@Valid Talento talento, BindingResult result) {
		if(result.hasErrors()) { return "codigo=06"; }
		
		if(talento.getIdTalento() != null) {
			Talento existe = repo.findById(talento.getIdTalento()).orElse(new Talento());
			
			if(!talento.getTalento().isEmpty()) { existe.setTalento(talento.getTalento()); }
			if(!talento.getDescricaoTalento().isEmpty()) { existe.setDescricaoTalento(talento.getDescricaoTalento()); }
			if(!talento.getRequisito().isEmpty()) { existe.setRequisito(talento.getRequisito()); } 

			repo.save(existe);
			return "codigo=12";
		}else{
			repo.save(talento);
			return "codigo=07";
		}
	}
	
	@PostMapping("/apagar")
	public String apagar(@RequestParam Integer id) {
		if(id != null) { repo.deleteById(id); }
		return "codigo=15";		//APAGOU
	}
}