package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dragonforge.aventurando.sistemas.dnd5e.strategies.FormularioStrategy;

@Controller
public class FormularioController {
	private final Map<String, FormularioStrategy> sMap;
	@Autowired
	public FormularioController(List<FormularioStrategy> strategies) {
		this.sMap = strategies.stream().collect(Collectors.toMap(FormularioStrategy::getTipoComponente, Function.identity()));
	}
	
	@GetMapping("/admin/formularios/{tipoComponente}")
	public String getFormularioFragment(@PathVariable String tipoComponente, Model model) {
		FormularioStrategy strategy = sMap.get(tipoComponente);
		if(strategy == null) {
			return "o-fragmento-de-erro";			//ACRESCENTAR ERRO AQUI DEPOIS
		}
		model.addAttribute("tipoComponente", tipoComponente);
		model.addAttribute("entidade", strategy.getEntidadeVazia());
		return "fragmentos/formularios :: form_dinamico";
	}
}