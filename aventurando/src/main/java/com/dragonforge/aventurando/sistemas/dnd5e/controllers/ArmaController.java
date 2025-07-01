package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Arma;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Dado;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Moeda;
import com.dragonforge.aventurando.sistemas.dnd5e.models.TipoDano;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.ArmaRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.DadoRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.DanoRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.MoedaRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/-api")
public class ArmaController {
	@Autowired
	private ArmaRepository repo;
	@Autowired
	private MoedaRepository repoCoin;
	@Autowired
	private DanoRepository repoDano;
	@Autowired
	private DadoRepository repoDado;
	
	@PostMapping(value = "/salvar")
	public String salvar(@Valid Arma weapon, @RequestParam("idMoeda") Integer idMoeda, @RequestParam("dado") Integer dado,
						@RequestParam("tipoDano") Integer dano, BindingResult result) {
		if(result.hasErrors()) { return "codigo=06"; }		//DEU ERRO EM ALGUMA COISA
		
		Moeda moedaSelect = repoCoin.findById(idMoeda).orElseThrow();
		TipoDano danoSelect = repoDano.findById(dano).orElseThrow();
		Dado dadoSelect = repoDado.findById(dado).orElseThrow();
		
		if(weapon.getIdArma() != null) {
			Arma existe = repo.findById(weapon.getIdArma()).orElse(new Arma());
			
			if(danoSelect != null ) { existe.setDano(danoSelect); }
			if(dadoSelect != null) { existe.setDadoDano(dadoSelect); }
			if(moedaSelect != null ) { existe.setMoeda(moedaSelect); }
			if(!weapon.getArma().isEmpty()) { existe.setArma(weapon.getArma()); }
			if(weapon.getPreco() != null) { existe.setPreco(weapon.getPreco()); }
			if(weapon.getQuantidadeDano() != null) { existe.setQuantidadeDano(weapon.getQuantidadeDano()); }
			if(weapon.getPeso() != null) { existe.setPeso(weapon.getPeso()); }
			if(!weapon.getPropriedades().isEmpty()) { existe.setPropriedades(weapon.getPropriedades()); }
			
			repo.save(existe);
			return "codigo=12";		//EDITADO
		}else{
			repo.save(weapon);
			return "codigo=07";		//CADASTROU
		}
	}
	
	@PostMapping("/apagar")
	public String apagar(@RequestParam Integer id) {
		if(id != null) { repo.deleteById(id); }
		return "codigo=15";		//APAGOU
	}
}
