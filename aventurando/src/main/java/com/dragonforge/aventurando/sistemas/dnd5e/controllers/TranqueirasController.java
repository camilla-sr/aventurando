package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Tranqueiras;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Bugiganga;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.TranqueirasRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.BugigangaRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/tranqueiras-api")
public class TranqueirasController {
	@Autowired
	private TranqueirasRepository repo;
	@Autowired
	private BugigangaRepository repoBugi;
	
	@PostMapping("/salvar")
	public String salvar(@Valid Tranqueiras tranq, @RequestParam("bugiganga") Integer bugi, BindingResult result) {
		if(result.hasErrors()) { return "codigo=06"; }
	
		Bugiganga bugiSelect = repoBugi.findById(bugi).orElseThrow();
		
		if(tranq.getIdTranqueira() != null) {
			Tranqueiras existe = repo.findById(tranq.getIdTranqueira()).orElse(new Tranqueiras());
			
			if(bugiSelect != null) { existe.setBugiganga(bugiSelect); }
			if(tranq.getQuantidade() != null) { existe.setQuantidade(tranq.getQuantidade()); }

			repo.save(existe);
			return "codigo=12";
		}else{
			repo.save(tranq);
			return "codigo=07";
		}
	}
	
	@PostMapping("/apagar")
	public String apagar(@RequestParam Integer id) {
		if(id != null) { repo.deleteById(id); }
		return "codigo=15";		//APAGOU
	}
}