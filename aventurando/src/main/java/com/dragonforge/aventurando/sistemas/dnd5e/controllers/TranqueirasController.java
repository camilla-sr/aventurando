package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	@Autowired private TranqueirasRepository repo;
	@Autowired private BugigangaRepository repoBugi;
	
	@PostMapping
	public String salvar(@Valid Tranqueiras tranq, @RequestParam("bugiganga") Integer bugi, BindingResult result, @RequestParam("url") String url) {
		if(result.hasErrors()) { return "redirect:" + url + "?codigo=06"; }
	
		Bugiganga bugiSelect = repoBugi.findById(bugi).orElseThrow();
		
		if(tranq.getId() != null) {
			Tranqueiras existe = repo.findById(tranq.getId()).orElse(new Tranqueiras());
			
			if(bugiSelect != null) { existe.setBugiganga(bugiSelect); }
			if(tranq.getQuantidade() != null) { existe.setQuantidade(tranq.getQuantidade()); }

			repo.save(existe);
			return "redirect:" + url + "?codigo=12";
		}else{
			repo.save(tranq);
			return "redirect:" + url + "?codigo=07";
		}
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@RequestParam Integer id, @RequestParam("url") String url) {
		repo.deleteById(id);
		return "redirect:" + url + "?codigo=15";
	}
}