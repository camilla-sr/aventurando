package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dragonforge.aventurando.central.models.Usuario;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Jogador;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Raca;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Classe;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Tendencia;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Antecedente;

import com.dragonforge.aventurando.central.repositorios.UsuarioRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.RacaRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.ClasseRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.JogadorRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.TendenciaRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.AntecedenteRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/jogador-api")
public class JogadorController {
	@Autowired
	private JogadorRepository repo;
	@Autowired
	private UsuarioRepository repoUser;
	@Autowired
	private RacaRepository repoRaca;
	@Autowired
	private ClasseRepository repoClass;
	@Autowired
	private TendenciaRepository repoTend;
	@Autowired
	private AntecedenteRepository repoAntec;
	
	@PostMapping("/salvar")
	public String salvar(@Valid Jogador jogador, @RequestParam("idUsuario") Integer user, @RequestParam("raca") Integer raca,
			 @RequestParam("classe") Integer classe, @RequestParam("tendencia") Integer tend,
			 @RequestParam("antecedente") Integer antec, BindingResult result) {
		if(result.hasErrors()) { return "codigo=06"; }

		Raca racaSelect = repoRaca.findById(raca).orElseThrow();
		Classe classSelect = repoClass.findById(classe).orElseThrow();
		Tendencia tendSelect = repoTend.findById(tend).orElseThrow();
		Antecedente antecSelect = repoAntec.findById(antec).orElseThrow();
		
		if(jogador.getIdJogador() != null) {
			Jogador existe = repo.findById(jogador.getIdJogador()).orElse(new Jogador());
			
			existe.setUsuario(user);
			if(racaSelect != null) { existe.setRaca(racaSelect); }
			if(classSelect != null) { existe.setClasse(classSelect); }
			if(tendSelect != null) { existe.setTendencia(tendSelect); }
			if(antecSelect != null) { existe.setAntecedente(antecSelect); }
			if(jogador.getXp() != null) { existe.setXp(jogador.getXp()); }
			if(jogador.getNivel() != null) { existe.setNivel(jogador.getNivel()); }
			if(jogador.getPontosVida() != null) { existe.setPontosVida(jogador.getPontosVida()); }
			if(jogador.getPontosVidaAtual() != null) { existe.setPontosVidaAtual(jogador.getPontosVidaAtual()); }
			if(jogador.getPontosVidaTemporaria() != null) { existe.setPontosVidaTemporaria(jogador.getPontosVidaTemporaria()); }
			if(jogador.getProficiencia() != null) { existe.setProficiencia(jogador.getProficiencia()); }
			if(jogador.getClasseArmadura() != null) { existe.setClasseArmadura(jogador.getClasseArmadura()); }
			if(jogador.getClasseArmaduraBonus() != null) { existe.setClasseArmaduraBonus(jogador.getClasseArmaduraBonus()); }
			if(jogador.getIniciativa() != null) { existe.setIniciativa(jogador.getIniciativa()); }
			if(jogador.getIniciativaBonus() != null) { existe.setIniciativaBonus(jogador.getIniciativaBonus()); }
			if(jogador.getDeslocamento() != null) { existe.setDeslocamento(jogador.getDeslocamento()); }
			if(jogador.getDeslocamentoBonus() != null) { existe.setDeslocamentoBonus(jogador.getDeslocamentoBonus()); }
			if(jogador.getDeslocamentoAgua() != null) { existe.setDeslocamentoAgua(jogador.getDeslocamentoAgua()); }
			if(jogador.getDeslocamentoEscalada() != null) { existe.setDeslocamentoEscalada(jogador.getDeslocamentoEscalada()); }
			if(jogador.getDeslocamentoVoo() != null) { existe.setDeslocamentoVoo(jogador.getDeslocamentoVoo()); }
			if(jogador.getPercepcaoPassiva() != null) { existe.setPercepcaoPassiva(jogador.getPercepcaoPassiva()); }
			
			if(jogador.getForca() != null) { existe.setForca(jogador.getForca()); }
			if(jogador.getModFor() != null) { existe.setModFor(jogador.getModFor()); }
			if(jogador.getDestreza() != null) { existe.setDestreza(jogador.getDestreza()); }
			if(jogador.getModDes() != null) { existe.setModDes(jogador.getModDes()); }
			if(jogador.getConstituicao() != null) { existe.setConstituicao(jogador.getConstituicao()); }
			if(jogador.getModCon() != null) { existe.setModCon(jogador.getModCon()); }
			if(jogador.getInteligencia() != null) { existe.setInteligencia(jogador.getInteligencia()); }
			if(jogador.getModInt() != null) { existe.setModInt(jogador.getModInt()); }
			if(jogador.getSabedoria() != null) { existe.setSabedoria(jogador.getSabedoria()); }
			if(jogador.getModSab() != null) { existe.setModSab(jogador.getModSab()); }
			if(jogador.getCarisma() != null) { existe.setCarisma(jogador.getCarisma()); }
			if(jogador.getModCar() != null) { existe.setModCar(jogador.getModCar()); }
			
			if(jogador.getAtletismoBase() != null) { existe.setAtletismoBase(jogador.getAtletismoBase()); }
			if(jogador.getAtletismo() != null) { existe.setAtletismo(jogador.getAtletismo()); }
			if(jogador.getAcrobaciaBase() != null) { existe.setAcrobaciaBase(jogador.getAcrobaciaBase()); }
			if(jogador.getAcrobacia() != null) { existe.setAcrobacia(jogador.getAcrobacia()); }
			if(jogador.getFurtividadeBase() != null) { existe.setFurtividadeBase(jogador.getFurtividadeBase()); }
			if(jogador.getFurtividade() != null) { existe.setFurtividade(jogador.getFurtividade()); }
			if(jogador.getPrestidigitacaoBase() != null) { existe.setPrestidigitacaoBase(jogador.getPrestidigitacaoBase()); }
			if(jogador.getPrestidigitacao() != null) { existe.setPrestidigitacao(jogador.getPrestidigitacao()); }
			if(jogador.getArcanismoBase() != null) { existe.setArcanismoBase(jogador.getArcanismoBase()); }
			if(jogador.getArcanismo() != null) { existe.setArcanismo(jogador.getArcanismo()); }
			if(jogador.getHistoriaBase() != null) { existe.setHistoriaBase(jogador.getHistoriaBase()); }
			if(jogador.getHistoria() != null) { existe.setHistoria(jogador.getHistoria()); }
			if(jogador.getInvestigacaoBase() != null) { existe.setInvestigacaoBase(jogador.getInvestigacaoBase()); }
			if(jogador.getInvestigacao() != null) { existe.setInvestigacao(jogador.getInvestigacao()); }
			if(jogador.getNaturezaBase() != null) { existe.setNaturezaBase(jogador.getNaturezaBase()); }
			if(jogador.getNatureza() != null) { existe.setNatureza(jogador.getNatureza()); }
			if(jogador.getReligiaoBase() != null) { existe.setReligiaoBase(jogador.getReligiaoBase()); }
			if(jogador.getReligiao() != null) { existe.setReligiao(jogador.getReligiao()); }
			if(jogador.getIntuicaoBase() != null) { existe.setIntuicaoBase(jogador.getIntuicaoBase()); }
			if(jogador.getIntuicao() != null) { existe.setIntuicao(jogador.getIntuicao()); }
			if(jogador.getLidarAnimaisBase() != null) { existe.setLidarAnimaisBase(jogador.getLidarAnimaisBase()); }
			if(jogador.getLidarAnimais() != null) { existe.setLidarAnimais(jogador.getLidarAnimais()); }
			if(jogador.getMedicinaBase() != null) { existe.setMedicinaBase(jogador.getMedicinaBase()); }
			if(jogador.getMedicina() != null) { existe.setMedicina(jogador.getMedicina()); }
			if(jogador.getPercepcaoBase() != null) { existe.setPercepcaoBase(jogador.getPercepcaoBase()); }
			if(jogador.getPercepcao() != null) { existe.setPercepcao(jogador.getPercepcao()); }
			if(jogador.getSobrevivenciaBase() != null) { existe.setSobrevivenciaBase(jogador.getSobrevivencia()); }
			if(jogador.getSobrevivencia() != null) { existe.setSobrevivencia(jogador.getSobrevivencia()); }
			if(jogador.getAtuacaoBase() != null) { existe.setAtuacaoBase(jogador.getAtuacaoBase()); }
			if(jogador.getAtuacao() != null) { existe.setAtuacao(jogador.getAtuacao()); }
			if(jogador.getEnganacaoBase() != null) { existe.setEnganacaoBase(jogador.getEnganacaoBase()); }
			if(jogador.getEnganacao() != null) { existe.setEnganacao(jogador.getEnganacao()); }
			if(jogador.getIntimidacaoBase() != null) { existe.setIntimidacaoBase(jogador.getIntimidacaoBase()); }
			if(jogador.getIntimidacao() != null) { existe.setIntimidacao(jogador.getIntimidacao()); }
			if(jogador.getPersuasaoBase() != null) { existe.setPersuasaoBase(jogador.getPersuasaoBase()); }
			if(jogador.getPersuasao() != null) { existe.setPersuasao(jogador.getPersuasao()); }
			
			repo.save(existe);
			return "codigo=12";
		}else{
			repo.save(jogador);
			return "codigo=07";
		}
	}
	
	@PostMapping("/apagar")
	public String apagar(@RequestParam Integer id) {
		if(id != null) { repo.deleteById(id); }
		return "codigo=15";		//APAGOU
	}
}