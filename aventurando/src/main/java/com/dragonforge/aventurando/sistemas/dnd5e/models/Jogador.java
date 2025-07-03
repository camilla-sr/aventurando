package com.dragonforge.aventurando.sistemas.dnd5e.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "JOGADOR")
public class Jogador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idJogador;
	@Column(name = "i_usuario")
	private Integer usuario;
	@ManyToOne
	@JoinColumn(name = "i_raca")
	private Raca raca;
	@ManyToOne
	@JoinColumn(name = "i_classe")
	private Classe classe;
	@OneToOne
	@JoinColumn(name = "i_tendencia")
	private Tendencia tendencia;
	@OneToOne
	@JoinColumn(name = "i_antecedente")
	private Antecedente antecedente;
	
	private Integer xp = 0;
	private Integer nivel = 0;
	private Integer pontosVida = 10;
	private Integer pontosVidaAtual = 0;
	private Integer pontosVidaTemporaria = 0;
	private Integer proficiencia = 0;
	private Integer classeArmadura = 0;			//CA
	private Integer classeArmaduraBonus = 0;	//CA
	private Integer iniciativa = 0;
	private Integer iniciativaBonus = 0;
	private Float deslocamento = 9.0f;
	private Float deslocamentoBonus = 0.0f;
	private Float deslocamentoAgua = 0.0f;
	private Float deslocamentoEscalada = 0.0f;
	private Float deslocamentoVoo = 0.0f;
	private Integer percepcaoPassiva = 0;
	
	//	ATRIBUTOS
	private Integer forca = 0;
	private Integer modFor = 0;
	private Integer destreza = 0;
	private Integer modDes = 0;
	private Integer constituicao = 0;
	private Integer modCon = 0;
	private Integer inteligencia = 0;
	private Integer modInt = 0;
	private Integer sabedoria = 0;
	private Integer modSab = 0;
	private Integer carisma = 0;
	private Integer modCar = 0;
	
	//PERÍCIAS
	private Integer atletismoBase = 0;			//usa modificador de força
	private Integer atletismo = 0;	//usa modificador + bônus
	private Integer acrobaciaBase = 0;
	private Integer acrobacia = 0;	//usa destreza
	private Integer furtividadeBase = 0;
	private Integer furtividade = 0;
	private Integer prestidigitacaoBase = 0;
	private Integer prestidigitacao = 0;
	private Integer arcanismoBase = 0;			//usa SABEDORIA
	private Integer arcanismo = 0;
	private Integer historiaBase = 0;
	private Integer historia = 0;
	private Integer investigacaoBase = 0;
	private Integer investigacao = 0;
	private Integer naturezaBase = 0;
	private Integer natureza = 0;
	private Integer religiaoBase = 0;
	private Integer religiao = 0;
	private Integer intuicaoBase = 0;
	private Integer intuicao = 0;
	private Integer lidarAnimaisBase = 0;
	private Integer lidarAnimais = 0;
	private Integer medicinaBase = 0;
	private Integer medicina = 0;
	private Integer percepcaoBase = 0;
	private Integer percepcao = 0;
	private Integer sobrevivenciaBase = 0;
	private Integer sobrevivencia = 0;
	private Integer atuacaoBase = 0;				// CARISMA
	private Integer atuacao = 0;
	private Integer enganacaoBase = 0;
	private Integer enganacao = 0;
	private Integer intimidacaoBase = 0;
	private Integer intimidacao = 0;
	private Integer persuasaoBase = 0;
	private Integer persuasao = 0;

	public Jogador() {}
	
	public Jogador( Integer idJogador, Integer usuario, Raca raca, Classe classe, Tendencia tendencia, Antecedente antecedente,
			Integer xp, Integer nivel, Integer pontosVida, Integer pontosVidaAtual, Integer pontosVidaTemporaria, Integer proficiencia,
			Integer classeArmadura, Integer classeArmaduraBonus, Integer iniciativa, Integer iniciativaBonus, Float deslocamento, Float deslocamentoBonus,
		    Float deslocamentoAgua, Float deslocamentoEscalada, Float deslocamentoVoo, Integer percepcaoPassiva, Integer forca, Integer modFor,
		    Integer destreza, Integer modDes, Integer constituicao, Integer modCon, Integer inteligencia, Integer modInt, Integer sabedoria, Integer modSab, Integer carisma,
		    Integer modCar, Integer atletismoBase, Integer atletismo, Integer acrobaciaBase, Integer acrobacia, Integer furtividadeBase, Integer furtividade,
		    Integer prestidigitacaoBase, Integer prestidigitacao, Integer arcanismoBase, Integer arcanismo, Integer historiaBase, Integer historia, Integer investigacaoBase,
		    Integer investigacao, Integer naturezaBase, Integer natureza, Integer religiaoBase, Integer religiao, Integer intuicaoBase, Integer intuicao, Integer lidarAnimaisBase,
		    Integer lidarAnimais, Integer medicinaBase, Integer medicina, Integer percepcaoBase, Integer percepcao, Integer sobrevivenciaBase, Integer sobrevivencia, Integer atuacaoBase, Integer atuacao, Integer enganacaoBase, Integer enganacao,
		    Integer intimidacaoBase, Integer intimidacao, Integer persuasaoBase, Integer persuasao ) {
		
		    this.idJogador = idJogador; this.usuario = usuario; this.raca = raca; this.classe = classe; this.tendencia = tendencia;
		    this.antecedente = antecedente; this.xp = xp; this.nivel = nivel; this.pontosVida = pontosVida; this.pontosVidaAtual = pontosVidaAtual;
		    this.pontosVidaTemporaria = pontosVidaTemporaria; this.proficiencia = proficiencia; this.classeArmadura = classeArmadura;
		    this.classeArmaduraBonus = classeArmaduraBonus; this.iniciativa = iniciativa; this.iniciativaBonus = iniciativaBonus;
		    this.deslocamento = deslocamento; this.deslocamentoBonus = deslocamentoBonus; this.deslocamentoAgua = deslocamentoAgua;
		    this.deslocamentoEscalada = deslocamentoEscalada; this.deslocamentoVoo = deslocamentoVoo; this.percepcaoPassiva = percepcaoPassiva; this.forca = forca;
		    this.modFor = modFor; this.destreza = destreza; this.modDes = modDes; this.constituicao = constituicao; this.modCon = modCon;
		    this.inteligencia = inteligencia; this.modInt = modInt; this.sabedoria = sabedoria; this.modSab = modSab; this.carisma = carisma;
		    this.modCar = modCar; this.atletismoBase = atletismoBase; this.atletismo = atletismo; this.acrobaciaBase = acrobaciaBase;
		    this.acrobacia = acrobacia; this.furtividadeBase = furtividadeBase; this.furtividade = furtividade; this.prestidigitacaoBase = prestidigitacaoBase;
		    this.prestidigitacao = prestidigitacao; this.arcanismoBase = arcanismoBase; this.arcanismo = arcanismo; this.historiaBase = historiaBase;
		    this.historia = historia; this.investigacaoBase = investigacaoBase; this.investigacao = investigacao; this.naturezaBase = naturezaBase;
		    this.natureza = natureza; this.religiaoBase = religiaoBase; this.religiao = religiao; this.intuicaoBase = intuicaoBase; this.intuicao = intuicao;
		    this.lidarAnimaisBase = lidarAnimaisBase; this.lidarAnimais = lidarAnimais; this.medicinaBase = medicinaBase; this.medicina = medicina;
		    this.percepcaoBase = percepcaoBase; this.percepcao = percepcao; this.sobrevivenciaBase = sobrevivenciaBase; this.sobrevivencia = sobrevivencia;
		    this.atuacaoBase = atuacaoBase; this.atuacao = atuacao; this.enganacaoBase = enganacaoBase; this.enganacao = enganacao; this.intimidacaoBase = intimidacaoBase;
		    this.intimidacao = intimidacao; this.persuasaoBase = persuasaoBase; this.persuasao = persuasao;
		}

	
	public Integer getUsuario() { return usuario; }
	public void setUsuario(Integer usuario) { this.usuario= usuario; }
	public Raca getRaca() { return raca; }
	public void setRaca(Raca raca) { this.raca = raca; }
	public Classe getClasse() { return classe; }
	public void setClasse(Classe classe) { this.classe = classe; }
	public Tendencia getTendencia() { return tendencia; }
	public void setTendencia(Tendencia tendencia) { this.tendencia = tendencia; }
	public Antecedente getAntecedente() { return antecedente; }
	public void setAntecedente(Antecedente antecedente) { this.antecedente = antecedente; }
	
	public Integer getIdJogador() { return idJogador; }
	public void setIdJogador(Integer idJogador) { this.idJogador = idJogador; }
	public Integer getXp() { return xp; }
	public void setXp(Integer xp) { this.xp = xp; }
	public Integer getNivel() { return nivel; }
	public void setNivel(Integer nivel) { this.nivel = nivel; }
	public Integer getPontosVida() { return pontosVida; }
	public void setPontosVida(Integer pontosVida) { this.pontosVida = pontosVida; }
	public Integer getPontosVidaAtual() { return pontosVidaAtual; }
	public void setPontosVidaAtual(Integer pontosVidaAtual) { this.pontosVidaAtual = pontosVidaAtual; }
	public Integer getPontosVidaTemporaria() { return pontosVidaTemporaria; }
	public void setPontosVidaTemporaria(Integer pontosVidaTemporaria) { this.pontosVidaTemporaria = pontosVidaTemporaria; }
	public Integer getProficiencia() { return proficiencia; }
	public void setProficiencia(Integer proficiencia) { this.proficiencia = proficiencia; }
	public Integer getClasseArmadura() { return classeArmadura; }
	public void setClasseArmadura(Integer classeArmadura) { this.classeArmadura = classeArmadura; }
	public Integer getClasseArmaduraBonus() { return classeArmaduraBonus; }
	public void setClasseArmaduraBonus(Integer classeArmaduraBonus) { this.classeArmaduraBonus = classeArmaduraBonus; }
	public Integer getIniciativa() { return iniciativa; }
	public void setIniciativa(Integer iniciativa) { this.iniciativa = iniciativa; }
	public Integer getIniciativaBonus() { return iniciativaBonus; }
	public void setIniciativaBonus(Integer iniciativaBonus) { this.iniciativaBonus = iniciativaBonus; }
	public Float getDeslocamento() { return deslocamento; }
	public void setDeslocamento(Float deslocamento) { this.deslocamento = deslocamento; }
	public Float getDeslocamentoBonus() { return deslocamentoBonus; }
	public void setDeslocamentoBonus(Float deslocamentoBonus) { this.deslocamentoBonus = deslocamentoBonus; }
	public Float getDeslocamentoAgua() { return deslocamentoAgua; }
	public void setDeslocamentoAgua(Float deslocamentoAgua) { this.deslocamentoAgua = deslocamentoAgua; }
	public Float getDeslocamentoEscalada() { return deslocamentoEscalada; }
	public void setDeslocamentoEscalada(Float deslocamentoEscalada) { this.deslocamentoEscalada = deslocamentoEscalada; }
	public Float getDeslocamentoVoo() { return deslocamentoVoo; }
	public void setDeslocamentoVoo(Float deslocamentoVoo) { this.deslocamentoVoo = deslocamentoVoo; }
	public Integer getPercepcaoPassiva() { return percepcaoPassiva; }
	public void setPercepcaoPassiva(Integer percepcaoPassiva) { this.percepcaoPassiva = percepcaoPassiva; }
	public Integer getForca() { return forca; }
	public void setForca(Integer forca) { this.forca = forca; }
	public Integer getModFor() { return modFor; }
	public void setModFor(Integer modFor) { this.modFor = modFor; }
	public Integer getDestreza() { return destreza; }
	public void setDestreza(Integer destreza) { this.destreza = destreza; }
	public Integer getModDes() { return modDes; }
	public void setModDes(Integer modDes) { this.modDes = modDes; }
	public Integer getConstituicao() { return constituicao; }
	public void setConstituicao(Integer constituicao) { this.constituicao = constituicao; }
	public Integer getModCon() { return modCon; }
	public void setModCon(Integer modCon) { this.modCon = modCon; }
	public Integer getInteligencia() { return inteligencia; }
	public void setInteligencia(Integer inteligencia) { this.inteligencia = inteligencia; }
	public Integer getModInt() { return modInt; }
	public void setModInt(Integer modInt) { this.modInt = modInt; }
	public Integer getSabedoria() { return sabedoria; }
	public void setSabedoria(Integer sabedoria) { this.sabedoria = sabedoria; }
	public Integer getModSab() { return modSab; }
	public void setModSab(Integer modSab) { this.modSab = modSab; }
	public Integer getCarisma() { return carisma; }
	public void setCarisma(Integer carisma) { this.carisma = carisma; }
	public Integer getModCar() { return modCar; }
	public void setModCar(Integer modCar) { this.modCar = modCar; }
	public Integer getAtletismoBase() { return atletismoBase; }
	public void setAtletismoBase(Integer atletismoBase) { this.atletismoBase = atletismoBase; }
	public Integer getAtletismo() { return atletismo; }
	public void setAtletismo(Integer atletismo) { this.atletismo = atletismo; }
	public Integer getAcrobaciaBase() { return acrobaciaBase; }
	public void setAcrobaciaBase(Integer acrobaciaBase) { this.acrobaciaBase = acrobaciaBase; }
	public Integer getAcrobacia() { return acrobacia; }
	public void setAcrobacia(Integer acrobacia) { this.acrobacia = acrobacia; }
	public Integer getFurtividadeBase() { return furtividadeBase; }
	public void setFurtividadeBase(Integer furtividadeBase) { this.furtividadeBase = furtividadeBase; }
	public Integer getFurtividade() { return furtividade; }
	public void setFurtividade(Integer furtividade) { this.furtividade = furtividade; }
	public Integer getPrestidigitacaoBase() { return prestidigitacaoBase; }
	public void setPrestidigitacaoBase(Integer prestidigitacaoBase) { this.prestidigitacaoBase = prestidigitacaoBase; }
	public Integer getPrestidigitacao() { return prestidigitacao; }
	public void setPrestidigitacao(Integer prestidigitacao) { this.prestidigitacao = prestidigitacao; }
	public Integer getArcanismoBase() { return arcanismoBase; }
	public void setArcanismoBase(Integer arcanismoBase) { this.arcanismoBase = arcanismoBase; }
	public Integer getArcanismo() { return arcanismo; }
	public void setArcanismo(Integer arcanismo) { this.arcanismo = arcanismo; }
	public Integer getHistoriaBase() { return historiaBase; }
	public void setHistoriaBase(Integer historiaBase) { this.historiaBase = historiaBase; }
	public Integer getHistoria() { return historia; }
	public void setHistoria(Integer historia) { this.historia = historia; }
	public Integer getInvestigacaoBase() { return investigacaoBase; }
	public void setInvestigacaoBase(Integer investigacaoBase) { this.investigacaoBase = investigacaoBase; }
	public Integer getInvestigacao() { return investigacao; }
	public void setInvestigacao(Integer investigacao) { this.investigacao = investigacao; }
	public Integer getNaturezaBase() { return naturezaBase; }
	public void setNaturezaBase(Integer naturezaBase) { this.naturezaBase = naturezaBase; }
	public Integer getNatureza() { return natureza; }
	public void setNatureza(Integer natureza) { this.natureza = natureza; }
	public Integer getReligiaoBase() { return religiaoBase; }
	public void setReligiaoBase(Integer religiaoBase) { this.religiaoBase = religiaoBase; }
	public Integer getReligiao() { return religiao; }
	public void setReligiao(Integer religiao) { this.religiao = religiao; }
	public Integer getIntuicaoBase() { return intuicaoBase; }
	public void setIntuicaoBase(Integer intuicaoBase) { this.intuicaoBase = intuicaoBase; }
	public Integer getIntuicao() { return intuicao; }
	public void setIntuicao(Integer intuicao) { this.intuicao = intuicao; }
	public Integer getLidarAnimaisBase() { return lidarAnimaisBase; }
	public void setLidarAnimaisBase(Integer lidarAnimaisBase) { this.lidarAnimaisBase = lidarAnimaisBase; }
	public Integer getLidarAnimais() { return lidarAnimais; }
	public void setLidarAnimais(Integer lidarAnimais) { this.lidarAnimais = lidarAnimais; }
	public Integer getMedicinaBase() { return medicinaBase; }
	public void setMedicinaBase(Integer medicinaBase) { this.medicinaBase = medicinaBase; }
	public Integer getMedicina() { return medicina; }
	public void setMedicina(Integer medicina) { this.medicina = medicina; }
	public Integer getPercepcaoBase() { return percepcaoBase; }
	public void setPercepcaoBase(Integer percepcaoBase) { this.percepcaoBase = percepcaoBase; }
	public Integer getPercepcao() { return percepcao; }
	public void setPercepcao(Integer percepcao) { this.percepcao = percepcao; }
	public Integer getSobrevivenciaBase() { return sobrevivenciaBase; }
	public void setSobrevivenciaBase(Integer sobrevivenciaBase) { this.sobrevivenciaBase = sobrevivenciaBase; }
	public Integer getSobrevivencia() { return sobrevivencia; }
	public void setSobrevivencia(Integer sobrevivencia) { this.sobrevivencia = sobrevivencia; }
	public Integer getAtuacaoBase() { return atuacaoBase; }
	public void setAtuacaoBase(Integer atuacaoBase) { this.atuacaoBase = atuacaoBase; }
	public Integer getAtuacao() { return atuacao; }
	public void setAtuacao(Integer atuacao) { this.atuacao = atuacao; }
	public Integer getEnganacaoBase() { return enganacaoBase; }
	public void setEnganacaoBase(Integer enganacaoBase) { this.enganacaoBase = enganacaoBase; }
	public Integer getEnganacao() { return enganacao; }
	public void setEnganacao(Integer enganacao) { this.enganacao = enganacao; }
	public Integer getIntimidacaoBase() { return intimidacaoBase; }
	public void setIntimidacaoBase(Integer intimidacaoBase) { this.intimidacaoBase = intimidacaoBase; }
	public Integer getIntimidacao() { return intimidacao; }
	public void setIntimidacao(Integer intimidacao) { this.intimidacao = intimidacao; }
	public Integer getPersuasaoBase() { return persuasaoBase; }
	public void setPersuasaoBase(Integer persuasaoBase) { this.persuasaoBase = persuasaoBase; }
	public Integer getPersuasao() { return persuasao; }
	public void setPersuasao(Integer persuasao) { this.persuasao = persuasao; }
}