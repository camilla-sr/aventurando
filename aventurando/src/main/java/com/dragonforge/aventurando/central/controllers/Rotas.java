package com.dragonforge.aventurando.central.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.dragonforge.aventurando.central.models.Usuario;
import com.dragonforge.aventurando.central.repositorios.SistemaRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.AntecedenteRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.BugigangaRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.DadoRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.DanoRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.GlossarioRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.HabMagiaRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.IdiomaRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.MoedaRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.RacaRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.TalentoRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.TendenciaRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class Rotas {
	@Autowired
	private Sessao s;
	@Autowired
	private SistemaRepository sis;
	@Autowired
	private RacaRepository raca;
	@Autowired
	private TendenciaRepository tend;
	@Autowired
	private AntecedenteRepository antec;
	@Autowired
	private TalentoRepository talent;
	@Autowired
	private DadoRepository dice;
	@Autowired
	private DanoRepository dano;
	@Autowired
	private MoedaRepository coin;
	@Autowired
	private BugigangaRepository bugi;
	@Autowired
	private IdiomaRepository idioma;
	@Autowired
	private HabMagiaRepository habMagia;
	@Autowired
	private GlossarioRepository magias;
	
	public String verificaUsuario(HttpSession session, String page) {
		if(!s.loginAtivo(session)) return "login";
		return page;
	}
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@GetMapping("painelSistema")
	public String painel() {
		return "dnd5e/painelSistema";
	}
	
	@GetMapping("/")
	public String index(HttpSession session, Model model) {
		if(s.verificaAcesso(session, "admin")) { 
			model.addAttribute("sistemas", sis.findAll());
			return "dnd5e/index_admin";
		}
		if(s.verificaAcesso(session, "jogador")) return "dnd5e/index_jogador";
		if(s.verificaAcesso(session, "mestre")) return "dnd5e/index_mestre";
		return "login";
	}
}