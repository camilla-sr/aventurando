package com.dragonforge.aventurando.models;

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
	
	@ManyToOne
	@JoinColumn(name = "i_usuario")
	private Usuario usuario;
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
	
	private int xp = 0;
	private int nivel = 0;
	private int pontosVida = 10;
	private int pontosVidaAtual = 0;
	private int pontosVidaTemporaria = 0;
	private int proficiencia = 0;
	private int classeArmadura = 0;			//CA
	private int classeArmaduraBonus = 0;	//CA
	private int iniciativa = 0;
	private int iniciativaBonus = 0;
	private float deslocamento = 9.0f;
	private float deslocamentoBonus = 0.0f;
	private float deslocamentoAgua = 0.0f;
	private float deslocamentoEscalada = 0.0f;
	private float deslocamentoVoo = 0.0f;
	private int percepcaoPassiva = 0;
	
	//	ATRIBUTOS
	private int forca = 0;
	private int modFor = 0;
	private int destreza = 0;
	private int modDes = 0;
	private int constituicao = 0;
	private int modCon = 0;
	private int inteligencia = 0;
	private int modInt = 0;
	private int sabedoria = 0;
	private int modSab = 0;
	private int carisma = 0;
	private int modCar = 0;
	
	//PERÍCIAS
	private int atletismoBase = 0;			//usa modificador de força
	private int atletismo = 0;	//usa modificador + bônus
	private int acrobaciaBase = 0;
	private int acrobacia = 0;	//usa destreza
	private int furtividadeBase = 0;
	private int furtividade = 0;
	private int prestidigitacaoBase = 0;
	private int prestidigitacao = 0;
	private int arcanismoBase = 0;			//usa SABEDORIA
	private int arcanismo = 0;
	private int historiaBase = 0;
	private int historia = 0;
	private int investigacaoBase = 0;
	private int investigacao = 0;
	private int naturezaBase = 0;
	private int natureza = 0;
	private int religiaoBase = 0;
	private int religiao = 0;
	private int intuicaoBase = 0;
	private int intuicao = 0;
	private int lidarAnimaisBase = 0;
	private int lidarAnimais = 0;
	private int medicinaBase = 0;
	private int medicina = 0;
	private int percepcaoBase = 0;
	private int percepcao = 0;
	private int sobrevivenciaBase = 0;
	private int sobrevivencia = 0;
	private int atuacaoBase = 0;				// CARISMA
	private int atuacao = 0;
	private int enganacaoBase = 0;
	private int enganacao = 0;
	private int intimidacaoBase = 0;
	private int intimidacao = 0;
	private int persuasaoBase = 0;
	private int persuasao = 0;
	
	public Jogador( Integer idJogador, int xp, int nivel, int pontosVida, int pontosVidaAtual, int pontosVidaTemporaria, int proficiencia,
			int classeArmadura, int classeArmaduraBonus, int iniciativa, int iniciativaBonus, float deslocamento, float deslocamentoBonus,
		    float deslocamentoAgua, float deslocamentoEscalada, float deslocamentoVoo, int percepcaoPassiva, int forca, int modFor,
		    int destreza, int modDes, int constituicao, int modCon, int inteligencia, int modInt, int sabedoria, int modSab, int carisma,
		    int modCar, int atletismoBase, int atletismo, int acrobaciaBase, int acrobacia, int furtividadeBase, int furtividade,
		    int prestidigitacaoBase, int prestidigitacao, int arcanismoBase, int arcanismo, int historiaBase, int historia, int investigacaoBase,
		    int investigacao, int naturezaBase, int natureza, int religiaoBase, int religiao, int intuicaoBase, int intuicao, int lidarAnimaisBase,
		    int lidarAnimais, int medicinaBase, int medicina, int percepcaoBase, int percepcao, int sobrevivenciaBase, int sobrevivencia, int atuacaoBase, int atuacao, int enganacaoBase, int enganacao,
		    int intimidacaoBase, int intimidacao, int persuasaoBase, int persuasao ) {
		
		    this.idJogador = idJogador; this.usuario = new Usuario(); this.raca = new Raca(); this.classe = new Classe(); this.tendencia = new Tendencia();
		    this.antecedente = new Antecedente(); this.xp = xp; this.nivel = nivel; this.pontosVida = pontosVida; this.pontosVidaAtual = pontosVidaAtual;
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

	
	public Usuario getUsuario() { return usuario; }
	public void setUsuario(Usuario usuario) { this.usuario = usuario; }
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
	public int getXp() { return xp; }
	public void setXp(int xp) { this.xp = xp; }
	public int getNivel() { return nivel; }
	public void setNivel(int nivel) { this.nivel = nivel; }
	public int getPontosVida() { return pontosVida; }
	public void setPontosVida(int pontosVida) { this.pontosVida = pontosVida; }
	public int getPontosVidaAtual() { return pontosVidaAtual; }
	public void setPontosVidaAtual(int pontosVidaAtual) { this.pontosVidaAtual = pontosVidaAtual; }
	public int getPontosVidaTemporaria() { return pontosVidaTemporaria; }
	public void setPontosVidaTemporaria(int pontosVidaTemporaria) { this.pontosVidaTemporaria = pontosVidaTemporaria; }
	public int getProficiencia() { return proficiencia; }
	public void setProficiencia(int proficiencia) { this.proficiencia = proficiencia; }
	public int getClasseArmadura() { return classeArmadura; }
	public void setClasseArmadura(int classeArmadura) { this.classeArmadura = classeArmadura; }
	public int getClasseArmaduraBonus() { return classeArmaduraBonus; }
	public void setClasseArmaduraBonus(int classeArmaduraBonus) { this.classeArmaduraBonus = classeArmaduraBonus; }
	public int getIniciativa() { return iniciativa; }
	public void setIniciativa(int iniciativa) { this.iniciativa = iniciativa; }
	public int getIniciativaBonus() { return iniciativaBonus; }
	public void setIniciativaBonus(int iniciativaBonus) { this.iniciativaBonus = iniciativaBonus; }
	public float getDeslocamento() { return deslocamento; }
	public void setDeslocamento(float deslocamento) { this.deslocamento = deslocamento; }
	public float getDeslocamentoBonus() { return deslocamentoBonus; }
	public void setDeslocamentoBonus(float deslocamentoBonus) { this.deslocamentoBonus = deslocamentoBonus; }
	public float getDeslocamentoAgua() { return deslocamentoAgua; }
	public void setDeslocamentoAgua(float deslocamentoAgua) { this.deslocamentoAgua = deslocamentoAgua; }
	public float getDeslocamentoEscalada() { return deslocamentoEscalada; }
	public void setDeslocamentoEscalada(float deslocamentoEscalada) { this.deslocamentoEscalada = deslocamentoEscalada; }
	public float getDeslocamentoVoo() { return deslocamentoVoo; }
	public void setDeslocamentoVoo(float deslocamentoVoo) { this.deslocamentoVoo = deslocamentoVoo; }
	public int getPercepcaoPassiva() { return percepcaoPassiva; }
	public void setPercepcaoPassiva(int percepcaoPassiva) { this.percepcaoPassiva = percepcaoPassiva; }
	public int getForca() { return forca; }
	public void setForca(int forca) { this.forca = forca; }
	public int getModFor() { return modFor; }
	public void setModFor(int modFor) { this.modFor = modFor; }
	public int getDestreza() { return destreza; }
	public void setDestreza(int destreza) { this.destreza = destreza; }
	public int getModDes() { return modDes; }
	public void setModDes(int modDes) { this.modDes = modDes; }
	public int getConstituicao() { return constituicao; }
	public void setConstituicao(int constituicao) { this.constituicao = constituicao; }
	public int getModCon() { return modCon; }
	public void setModCon(int modCon) { this.modCon = modCon; }
	public int getInteligencia() { return inteligencia; }
	public void setInteligencia(int inteligencia) { this.inteligencia = inteligencia; }
	public int getModInt() { return modInt; }
	public void setModInt(int modInt) { this.modInt = modInt; }
	public int getSabedoria() { return sabedoria; }
	public void setSabedoria(int sabedoria) { this.sabedoria = sabedoria; }
	public int getModSab() { return modSab; }
	public void setModSab(int modSab) { this.modSab = modSab; }
	public int getCarisma() { return carisma; }
	public void setCarisma(int carisma) { this.carisma = carisma; }
	public int getModCar() { return modCar; }
	public void setModCar(int modCar) { this.modCar = modCar; }
	public int getAtletismoBase() { return atletismoBase; }
	public void setAtletismoBase(int atletismoBase) { this.atletismoBase = atletismoBase; }
	public int getAtletismo() { return atletismo; }
	public void setAtletismo(int atletismo) { this.atletismo = atletismo; }
	public int getAcrobaciaBase() { return acrobaciaBase; }
	public void setAcrobaciaBase(int acrobaciaBase) { this.acrobaciaBase = acrobaciaBase; }
	public int getAcrobacia() { return acrobacia; }
	public void setAcrobacia(int acrobacia) { this.acrobacia = acrobacia; }
	public int getFurtividadeBase() { return furtividadeBase; }
	public void setFurtividadeBase(int furtividadeBase) { this.furtividadeBase = furtividadeBase; }
	public int getFurtividade() { return furtividade; }
	public void setFurtividade(int furtividade) { this.furtividade = furtividade; }
	public int getPrestidigitacaoBase() { return prestidigitacaoBase; }
	public void setPrestidigitacaoBase(int prestidigitacaoBase) { this.prestidigitacaoBase = prestidigitacaoBase; }
	public int getPrestidigitacao() { return prestidigitacao; }
	public void setPrestidigitacao(int prestidigitacao) { this.prestidigitacao = prestidigitacao; }
	public int getArcanismoBase() { return arcanismoBase; }
	public void setArcanismoBase(int arcanismoBase) { this.arcanismoBase = arcanismoBase; }
	public int getArcanismo() { return arcanismo; }
	public void setArcanismo(int arcanismo) { this.arcanismo = arcanismo; }
	public int getHistoriaBase() { return historiaBase; }
	public void setHistoriaBase(int historiaBase) { this.historiaBase = historiaBase; }
	public int getHistoria() { return historia; }
	public void setHistoria(int historia) { this.historia = historia; }
	public int getInvestigacaoBase() { return investigacaoBase; }
	public void setInvestigacaoBase(int investigacaoBase) { this.investigacaoBase = investigacaoBase; }
	public int getInvestigacao() { return investigacao; }
	public void setInvestigacao(int investigacao) { this.investigacao = investigacao; }
	public int getNaturezaBase() { return naturezaBase; }
	public void setNaturezaBase(int naturezaBase) { this.naturezaBase = naturezaBase; }
	public int getNatureza() { return natureza; }
	public void setNatureza(int natureza) { this.natureza = natureza; }
	public int getReligiaoBase() { return religiaoBase; }
	public void setReligiaoBase(int religiaoBase) { this.religiaoBase = religiaoBase; }
	public int getReligiao() { return religiao; }
	public void setReligiao(int religiao) { this.religiao = religiao; }
	public int getIntuicaoBase() { return intuicaoBase; }
	public void setIntuicaoBase(int intuicaoBase) { this.intuicaoBase = intuicaoBase; }
	public int getIntuicao() { return intuicao; }
	public void setIntuicao(int intuicao) { this.intuicao = intuicao; }
	public int getLidarAnimaisBase() { return lidarAnimaisBase; }
	public void setLidarAnimaisBase(int lidarAnimaisBase) { this.lidarAnimaisBase = lidarAnimaisBase; }
	public int getLidarAnimais() { return lidarAnimais; }
	public void setLidarAnimais(int lidarAnimais) { this.lidarAnimais = lidarAnimais; }
	public int getMedicinaBase() { return medicinaBase; }
	public void setMedicinaBase(int medicinaBase) { this.medicinaBase = medicinaBase; }
	public int getMedicina() { return medicina; }
	public void setMedicina(int medicina) { this.medicina = medicina; }
	public int getPercepcaoBase() { return percepcaoBase; }
	public void setPercepcaoBase(int percepcaoBase) { this.percepcaoBase = percepcaoBase; }
	public int getPercepcao() { return percepcao; }
	public void setPercepcao(int percepcao) { this.percepcao = percepcao; }
	public int getSobrevivenciaBase() { return sobrevivenciaBase; }
	public void setSobrevivenciaBase(int sobrevivenciaBase) { this.sobrevivenciaBase = sobrevivenciaBase; }
	public int getSobrevivencia() { return sobrevivencia; }
	public void setSobrevivencia(int sobrevivencia) { this.sobrevivencia = sobrevivencia; }
	public int getAtuacaoBase() { return atuacaoBase; }
	public void setAtuacaoBase(int atuacaoBase) { this.atuacaoBase = atuacaoBase; }
	public int getAtuacao() { return atuacao; }
	public void setAtuacao(int atuacao) { this.atuacao = atuacao; }
	public int getEnganacaoBase() { return enganacaoBase; }
	public void setEnganacaoBase(int enganacaoBase) { this.enganacaoBase = enganacaoBase; }
	public int getEnganacao() { return enganacao; }
	public void setEnganacao(int enganacao) { this.enganacao = enganacao; }
	public int getIntimidacaoBase() { return intimidacaoBase; }
	public void setIntimidacaoBase(int intimidacaoBase) { this.intimidacaoBase = intimidacaoBase; }
	public int getIntimidacao() { return intimidacao; }
	public void setIntimidacao(int intimidacao) { this.intimidacao = intimidacao; }
	public int getPersuasaoBase() { return persuasaoBase; }
	public void setPersuasaoBase(int persuasaoBase) { this.persuasaoBase = persuasaoBase; }
	public int getPersuasao() { return persuasao; }
	public void setPersuasao(int persuasao) { this.persuasao = persuasao; }
}