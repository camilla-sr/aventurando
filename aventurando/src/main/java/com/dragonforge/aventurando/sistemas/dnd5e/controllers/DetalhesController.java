package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.DetalhesPersonagem;
import com.dragonforge.aventurando.sistemas.dnd5e.models.HabilidadeClasse;
import com.dragonforge.aventurando.sistemas.dnd5e.models.HabilidadeRaca;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Arquetipo;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Talento;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Idioma;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Arma;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Armadura;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Ferramenta;

import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.DetalhesRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.HabClasseRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.HabRacaRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.ArquetipoRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.TalentoRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.IdiomaRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.ArmaRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.ArmaduraRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.FerramentaRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/detalhes-api")
public class DetalhesController {
	@Autowired
	private DetalhesRepository repo;
	@Autowired
	private HabClasseRepository repoClass;
	@Autowired
	private HabRacaRepository repoRaca;
	@Autowired
	private ArquetipoRepository repoArq;
	@Autowired
	private TalentoRepository repoTalen;
	@Autowired
	private IdiomaRepository repoIdi;
	@Autowired
	private ArmaRepository repoWeapon;
	@Autowired
	private ArmaduraRepository repoArmor;
	@Autowired
	private FerramentaRepository repoTool;
	
	@PostMapping("/salvar")
	public String salvar(@Valid DetalhesPersonagem detail, @RequestParam("idJogador") Integer player, @RequestParam("habclasse") Integer classe,
				@RequestParam("habraca") Integer raca, @RequestParam("arquetipo") Integer arquetipo, @RequestParam("talento") Integer talento,
				@RequestParam("idioma") Integer idioma,  @RequestParam("prof_weapon") Integer weapon,  @RequestParam("prof_armor") Integer armor,
				@RequestParam("prof_tool") Integer tool, BindingResult result) {
		if(result.hasErrors()) { return "codigo=06"; }

		HabilidadeClasse classSelect = repoClass.findById(classe).orElseThrow();
		HabilidadeRaca racaSelect = repoRaca.findById(raca).orElseThrow();
		Arquetipo arqSelect = repoArq.findById(arquetipo).orElseThrow();
		Talento talenSelect = repoTalen.findById(talento).orElseThrow();
		Idioma idiomaSelect = repoIdi.findById(idioma).orElseThrow();
		Arma weaponSelect = repoWeapon.findById(weapon).orElseThrow();
		Armadura armorSelect = repoArmor.findById(armor).orElseThrow();
		Ferramenta toolSelect = repoTool.findById(tool).orElseThrow();
		
		if(detail.getIdDetalhes() != null) {
			DetalhesPersonagem existe = repo.findById(detail.getIdDetalhes()).orElse(new DetalhesPersonagem());
			
			existe.setJogador(player);
			if(classSelect != null) { existe.setHabilidadeClasse(classSelect); }
			if(racaSelect != null) { existe.setHabilidadeRaca(racaSelect); }
			if(arqSelect != null) { existe.setArquetipo(arqSelect); }
			if(talenSelect != null) { existe.setTalento(talenSelect); }
			if(idiomaSelect != null) { existe.setIdioma(idiomaSelect); }
			if(weaponSelect != null) { existe.setArma(weaponSelect); }
			if(armorSelect != null) { existe.setArmadura(armorSelect); }
			if(toolSelect != null) { existe.setFerramenta(toolSelect); }
			
			repo.save(existe);
			return "codigo=12";
		}else{
			repo.save(detail);
			return "codigo=07";
		}
	}
	
	@PostMapping("/apagar")
	public String apagar(@RequestParam Integer id) {
		if(id != null) { repo.deleteById(id); }
		return "codigo=15";		//APAGOU
	}
}