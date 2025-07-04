package com.dragonforge.aventurando.sistemas.dnd5e.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dragonforge.aventurando.central.repositorios.UsuarioRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/tabela")
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
	@Autowired
    private ObjectMapper objectMapper;

	
    private List<Map<String, Object>> converter(Iterable<?> dados) {
        return StreamSupport.stream(dados.spliterator(), false)
                .map(dado -> objectMapper.convertValue(dado, Map.class))
                .collect(Collectors.toList());
    }
	
	@GetMapping("/{componente}")
	public String exibirTabela(@PathVariable String componente, Model model, HttpSession session) {
		List<String> cabecalho = new ArrayList<>();
		List<String> campos = new ArrayList<>();
		
		switch(componente.toLowerCase()) {
			case "antecedentes":
				model.addAttribute("titulo", "Antecedentes");
				model.addAttribute("dados", converter(repoAntec.findAll()));
				cabecalho.addAll(Arrays.asList("ID", "Descricão"));
				campos.addAll(Arrays.asList("id", "descricao"));
				break;
			case "armas":
				model.addAttribute("titulo", "Armas");
				model.addAttribute("dados", converter(repoWeapon.findAll()));
				cabecalho.addAll(Arrays.asList("ID", "Nome", "Dano", "Preço", "Moeda", "Peso", "Propriedade"));
				campos.addAll(Arrays.asList("id", "nome", "dano", "preco", "moeda", "peso", "propriedade"));
				break;
			case "armaduras":
				model.addAttribute("titulo", "Armaduras");
				model.addAttribute("dados", converter(repoArmor.findAll()));
				cabecalho.addAll(Arrays.asList("ID", "Tipo", "Preco", "Moeda", "CA", "Modificador", "Requisito", "Desvantagem", "Peso"));
				campos.addAll(Arrays.asList("id", "tipo", "preco", "moeda", "ca", "modificador", "requisito", "desvantagem", "peso"));
				break;
			case "arquetipos":
				model.addAttribute("titulo", "Arquétipos");
				model.addAttribute("dados", converter(repoArq.findAll()));
				cabecalho.addAll(Arrays.asList("ID", "Classe", "Título", "Descrição"));
				campos.addAll(Arrays.asList("id", "classe", "titulo", "descricao"));
				break;
			case "bugigangas":
				model.addAttribute("titulo", "Bugigangas");
				model.addAttribute("dados", converter(repoBugi.findAll()));
				cabecalho.addAll(Arrays.asList("ID", "Descrição"));
				campos.addAll(Arrays.asList("id", "descricao"));
				break;
			case "classes":
				model.addAttribute("titulo", "Classes");
				model.addAttribute("dados", converter(repoClasse.findAll()));
				cabecalho.addAll(Arrays.asList("ID", "Classe", "Descrição", "Habilidade Primária", "Dado de vida",
											"Proficiencia em Arma ou Armadura", "Proficiencia em Teste de Resistência"));
				campos.addAll(Arrays.asList("id", "classe", "descricao", "habprimaria", "dadovida", "parma", "pteste"));
				break;
			case "dados":
				model.addAttribute("titulo", "Dados");
				model.addAttribute("dados", converter(repoDice.findAll()));
				cabecalho.addAll(Arrays.asList("ID", "Tipo"));
				campos.addAll(Arrays.asList("id", "tipo"));
				break;
			case "defeitos":
				model.addAttribute("titulo", "Defeitos");
				model.addAttribute("dados", converter(repoDef.findAll()));
				cabecalho.addAll(Arrays.asList("ID", "Antecedente", "Descrição"));
				campos.addAll(Arrays.asList("id", "antecedente", "descricao"));
				break;
			case "equipamentos":
				model.addAttribute("titulo", "Equipamentos");
				model.addAttribute("dados", converter(repoEquip.findAll()));
				cabecalho.addAll(Arrays.asList("ID", "Item", "Preço", "Moeda", "Peso"));
				campos.addAll(Arrays.asList("id", "item", "preco", "moeda", "peso"));
				break;
			case "ferramentas":
				model.addAttribute("titulo", "Ferramentas");
				model.addAttribute("dados", converter(repoTool.findAll()));
				cabecalho.addAll(Arrays.asList("ID", "Ferramenta", "Descrição", "Preço", "Moeda", "Peso"));
				campos.addAll(Arrays.asList("id", "ferramenta", "descricao", "preco", "moeda", "peso"));
				break;
			case "glossario":
				model.addAttribute("titulo", "Glossário de Magias");
				model.addAttribute("dados", converter(repoGloss.findAll()));
				cabecalho.addAll(Arrays.asList("ID", "Magia", "Nível", "Descrição"));
				campos.addAll(Arrays.asList("id", "magia", "nivel", "descricao"));
				break;
			case "habchave":
				model.addAttribute("titulo", "Habilidades Chave");
				model.addAttribute("dados", converter(repoGloss.findAll()));
				cabecalho.addAll(Arrays.asList("ID", "Habilidade"));
				campos.addAll(Arrays.asList("id", "habilidade"));
				break;
			case "ideais":
				model.addAttribute("titulo", "Ideais");
				model.addAttribute("dados", converter(repoIdeal.findAll()));
				cabecalho.addAll(Arrays.asList("ID", "Antecedente", "Descrição"));
				campos.addAll(Arrays.asList("id", "antecedente", "descricao"));
				break;
			case "idiomas":
				model.addAttribute("titulo", "Idiomas");
				model.addAttribute("dados", converter(repoIdi.findAll()));
				cabecalho.addAll(Arrays.asList("ID", "Descrição", "Alfabeto"));
				campos.addAll(Arrays.asList("id", "descricao", "alfabeto"));
				break;
			case "jogadores":
				model.addAttribute("titulo", "Jogadores");
				model.addAttribute("dados", converter(repoUser.findByAcesso("jogador")));
				cabecalho.addAll(Arrays.asList("ID", "Nome", "Usuário", "Personagens"));
				campos.addAll(Arrays.asList("id", "nome", "usuario", "personagens"));
				break;
			case "mestres":
				model.addAttribute("titulo", "Mestres");
				model.addAttribute("dados", converter(repoUser.findByAcesso("mestre")));
				cabecalho.addAll(Arrays.asList("ID", "Nome", "Usuário", "Campanhas"));
				campos.addAll(Arrays.asList("id", "nome", "usuario", "campanhas"));
				break;
			case "moedas":
				model.addAttribute("titulo", "Moedas");
				model.addAttribute("dados", converter(repoMoeda.findAll()));
				cabecalho.addAll(Arrays.asList("ID", "Moeda", "Peso"));
				campos.addAll(Arrays.asList("id", "moeda", "peso"));
				break;
			case "racas":
				model.addAttribute("titulo", "Raças");
				model.addAttribute("dados", converter(repoRaca.findAll()));
				cabecalho.addAll(Arrays.asList("ID", "Raça", "Deslocamento"));
				campos.addAll(Arrays.asList("id", "raca", "deslocamento"));
				break;
			case "talentos":
				model.addAttribute("titulo", "Talentos");
				model.addAttribute("dados", converter(repoTalent.findAll()));
				cabecalho.addAll(Arrays.asList("ID", "Talento", "Descrição", "Requisito"));
				campos.addAll(Arrays.asList("id", "talento", "descricao", "requisito"));
				break;
			case "tendencias":
				model.addAttribute("titulo", "Tendências");
				model.addAttribute("dados", converter(repoTend.findAll()));
				cabecalho.addAll(Arrays.asList("ID", "Descrição"));
				campos.addAll(Arrays.asList("id", "descricao"));
				break;
			case "danos":
				model.addAttribute("titulo", "Tipos de Dano");
				model.addAttribute("dados", converter(repoHit.findAll()));
				cabecalho.addAll(Arrays.asList("ID", "Descrição"));
				campos.addAll(Arrays.asList("id", "descricao"));
				break;
			case "tracos":
				model.addAttribute("titulo", "Traços de Personalidadde");
				model.addAttribute("dados", converter(repoTraco.findAll()));
				cabecalho.addAll(Arrays.asList("ID", "Antecedente", "Descrição"));
				campos.addAll(Arrays.asList("id", "antecedente", "descricao"));
				break;
			case "vinculos":
				model.addAttribute("titulo", "Vínculos");
				model.addAttribute("dados", converter(repoLink.findAll()));
				cabecalho.addAll(Arrays.asList("ID", "Antecedente", "Descrição"));
				campos.addAll(Arrays.asList("id", "antecedente", "descricao"));
				break;
			default:
				model.addAttribute("titulo", "Componente não encontrado");
				model.addAttribute("dados", null);
		}
		model.addAttribute("cabecalho", cabecalho);
		model.addAttribute("campos", campos);
		model.addAttribute("componente", componente.toLowerCase());
		return "dnd5e/tabelaComponente";
	}
}