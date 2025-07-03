package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dragonforge.aventurando.central.repositorios.UsuarioRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.*;

@Controller
@RequestMapping("dnd5e/componente")
public class ComponenteController {
	@Autowired
	private AntecedenteRepository repoAntec;
	@Autowired
	private ArmaRepository repoWeapon;
	@Autowired
	private ArmaduraRepository repoArmor;
	@Autowired
	private ArquetipoRepository repoArq;
	@Autowired
	private BugigangaRepository repoBugi;
	@Autowired
	private ClasseRepository repoClasse;
	@Autowired
	private DadoRepository repoDice;
	@Autowired
	private DefeitoRepository repoDef;
	@Autowired
	private EquipamentoRepository repoEquip;
	@Autowired
	private FerramentaRepository repoTool;
	@Autowired
	private GlossarioRepository repoGloss;
	@Autowired
	private IdealRepository repoIdeal;
	@Autowired
	private IdiomaRepository repoIdi;
	@Autowired
	private UsuarioRepository repoUser;
	@Autowired
	private MoedaRepository repoMoeda;
	@Autowired
	private RacaRepository repoRaca;
	@Autowired
	private TalentoRepository repoTalent;
	@Autowired
	private TendenciaRepository repoTend;
	@Autowired
	private DanoRepository repoHit;
	@Autowired
	private TracoRepository repoTraco;
	@Autowired
	private VinculoRepository repoLink;
	
	@GetMapping("/{componente}")
	public String exibirTabela(@PathVariable String componente, Model model) {
		switch(componente.toLowerCase()) {
			case "antecedentes":
				model.addAttribute("titulo", "Antecedentes");
				model.addAttribute("dados", repoAntec.findAll());
				break;
			case "armas":
				model.addAttribute("titulo", "Armas");
				model.addAttribute("dados", repoWeapon.findAll());
				break;
			case "armaduras":
				model.addAttribute("titulo", "Armaduras");
				model.addAttribute("dados", repoArmor.findAll());
				break;
			case "arquetipos":
				model.addAttribute("titulo", "Arquétipos");
				model.addAttribute("dados", repoArq.findAll());
				break;
			case "bugigangas":
				model.addAttribute("titulo", "Bugigangas");
				model.addAttribute("dados", repoBugi.findAll());
				break;
			case "classes":
				model.addAttribute("titulo", "Classes");
				model.addAttribute("dados", repoClasse.findAll());
				break;
			case "dados":
				model.addAttribute("titulo", "Dados");
				model.addAttribute("dados", repoDice.findAll());
				break;
			case "defeitos":
				model.addAttribute("titulo", "Defeitos");
				model.addAttribute("dados", repoDef.findAll());
				break;
			case "equipamentos":
				model.addAttribute("titulo", "Equipamentos");
				model.addAttribute("dados", repoEquip.findAll());
				break;
			case "ferramentas":
				model.addAttribute("titulo", "Ferramentas");
				model.addAttribute("dados", repoTool.findAll());
				break;
			case "glossario":
				model.addAttribute("titulo", "Glossário de Magias");
				model.addAttribute("dados", repoGloss.findAll());
				break;
			case "ideais":
				model.addAttribute("titulo", "Ideais");
				model.addAttribute("dados", repoIdeal.findAll());
				break;
			case "idiomas":
				model.addAttribute("titulo", "Idiomas");
				model.addAttribute("dados", repoIdi.findAll());
				break;
			case "jogadores":
				model.addAttribute("titulo", "Jogadores");
				model.addAttribute("dados", repoUser.findByAcesso("jogador"));
				break;
			case "mestres":
				model.addAttribute("titulo", "Mestres");
				model.addAttribute("dados", repoUser.findByAcesso("mestre"));
				break;
			case "moedas":
				model.addAttribute("titulo", "Moedas");
				model.addAttribute("dados", repoMoeda.findAll());
				break;
			case "racas":
				model.addAttribute("titulo", "Raças");
				model.addAttribute("dados", repoRaca.findAll());
				break;
			case "talentos":
				model.addAttribute("titulo", "Talentos");
				model.addAttribute("dados", repoTalent.findAll());
				break;
			case "tendencias":
				model.addAttribute("titulo", "Tendências");
				model.addAttribute("dados", repoTend.findAll());
				break;
			case "danos":
				model.addAttribute("titulo", "Tipos de Dano");
				model.addAttribute("dados", repoHit.findAll());
				break;
			case "tracos":
				model.addAttribute("titulo", "Traços de Personalidadde");
				model.addAttribute("dados", repoTraco.findAll());
				break;
			case "vinculos":
				model.addAttribute("titulo", "Vínculos");
				model.addAttribute("dados", repoLink.findAll());
				break;
			default:
				model.addAttribute("titulo", "Componente não encontrado");
				model.addAttribute("dados", null);
		}
		model.addAttribute("componente", componente.toLowerCase());
		return "dnd5e/tabela-componente";
	}
}