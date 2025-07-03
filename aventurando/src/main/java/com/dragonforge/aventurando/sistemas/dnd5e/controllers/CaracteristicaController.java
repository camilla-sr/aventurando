package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.sistemas.dnd5e.models.Caracteristicas;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Jogador;
import com.dragonforge.aventurando.sistemas.dnd5e.models.TracoPersonalidade;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Ideal;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Vinculo;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Defeito;

import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.CaracteristicaRepository;
import com.dragonforge.aventurando.central.models.Usuario;
import com.dragonforge.aventurando.central.repositorios.UsuarioRepository;		//jogador
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.TracoRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.IdealRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.VinculoRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.DefeitoRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/caracteristica-api")
public class CaracteristicaController {
	@Autowired
	private CaracteristicaRepository repo;
	@Autowired
	private TracoRepository repoTraco;
	@Autowired
	private IdealRepository repoIdeal;
	@Autowired
	private VinculoRepository repoVinc;
	@Autowired
	private DefeitoRepository repoDef;
	
	@PostMapping("/salvar")
	public String salvar(@Valid Caracteristicas carac, @RequestParam("idJogador") Integer player, @RequestParam("traco") Integer traco,
			@RequestParam("ideal") Integer ideal, @RequestParam("vinculo") Integer vinc, @RequestParam("defeito") Integer def, BindingResult result) {
		if(result.hasErrors()) { return "codigo=06"; }

		TracoPersonalidade tracoSelect = repoTraco.findById(traco).orElseThrow();
		Ideal idealSelect = repoIdeal.findById(ideal).orElseThrow();
		Vinculo vincSelect = repoVinc.findById(vinc).orElseThrow();
		Defeito defSelect = repoDef.findById(def).orElseThrow();
		
		if(carac.getIdCaracteristica() != null) {
			Caracteristicas existe = repo.findById(carac.getIdCaracteristica()).orElse(new Caracteristicas());
			
			existe.setPlayer(player);
			if(tracoSelect != null) { existe.setTraco(tracoSelect); }
			if(idealSelect != null) { existe.setIdeal(idealSelect); }
			if(vincSelect != null) { existe.setVinculo(vincSelect); }
			if(defSelect != null) { existe.setDefeito(defSelect); }
			if(!carac.getFoto().isEmpty()) { existe.setFoto(carac.getFoto()); }
			if(carac.getIdade() != null) { existe.setIdade(carac.getIdade()); }
			if(carac.getPeso() != null) { existe.setPeso(carac.getPeso()); }
			if(!carac.getCabelos().isEmpty()) { existe.setCabelos(carac.getCabelos()); }
			if(!carac.getOlhos().isEmpty()) { existe.setOlhos(carac.getOlhos()); }
			if(!carac.getPele().isEmpty()) { existe.setPele(carac.getPele()); }
			if(!carac.getCaracteristicaPersonalizada().isEmpty()) { existe.setCaracteristicaPersonalizada(carac.getCaracteristicaPersonalizada()); }
			if(!carac.getHistoria().isEmpty()) { existe.setHistoria(carac.getHistoria()); }
			if(!carac.getAliadosOrg().isEmpty()) { existe.setAliadosOrg(carac.getAliadosOrg()); }
			if(!carac.getTesouro().isEmpty()) { existe.setTesouro(carac.getTesouro()); }
			
			repo.save(existe);
			return "codigo=12";
		}else{
			repo.save(carac);
			return "codigo=07";
		}
	}
	
	@PostMapping("/apagar")
	public String apagar(@RequestParam Integer id) {
		if(id != null) { repo.deleteById(id); }
		return "codigo=15";		//APAGOU
	}
}