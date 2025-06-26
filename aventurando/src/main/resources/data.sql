create database if not exists arquivoFichas;
use arquivoFichas;

# TABELAS SEM FK
create table if not exists USUARIO(
	id_usuario			int unsigned auto_increment primary key,
	nome				varchar(35) not null,
	usuario				varchar(15) not null,
    senha				varchar(255) not null			# desse tamanho pra garantir senhas criptografias
);

create table if not exists RACAS(
	id_raca				int unsigned auto_increment primary key,
    raca				varchar(50) not null unique,		# incluindo sub-raças
    deslocamento		decimal(4,1) not null				# em Metros
);

create table if not exists TENDENCIAS(
	id_tendencia		int unsigned auto_increment primary key,
    tendencia			varchar(25) not null unique
);

create table if not exists ANTECEDENTES(
	id_antecedente		int unsigned auto_increment primary key,
    antecedente			varchar(30) not null unique
);

create table if not exists TALENTOS(
	id_talento			int unsigned auto_increment primary key,
    talento				varchar(50) not null unique,
    descricao_talento	text not null,
    requisito			varchar(30) default 'Não necessário'
);

create table if not exists DADOS(
	id_dado				int unsigned auto_increment primary key,
    tipo				varchar(3)
);

create table if not exists TIPO_DANO(
	id_dano				int unsigned auto_increment primary key,
    descricao_dano		varchar(30) unique
);

create table if not exists MOEDA(
	id_moeda	int unsigned auto_increment primary key,
	moeda		char(2) not null,
    peso		decimal(2,2) default 0.0
);

create table if not exists BUGIGANGAS(
	id_bugiganga		int unsigned auto_increment primary key,
    descricao_bugiganga	varchar(250) not null
);

create table if not exists IDIOMAS(
	id_idioma			int unsigned auto_increment primary key,
    descricao_idioma	varchar(30) not null,
    alfabeto			varchar(45) default ''
);

create table if not exists HABILIDADE_MAGIA(
	id_habilidade		int unsigned auto_increment primary key,
    habilidade_chave	varchar(30) not null
);

create table if not exists GLOSSARIO_MAGIAS(
	id_magia			int unsigned auto_increment primary key,
    magia				varchar(60) not null unique,
    nivel				int not null,
    descricao_magia		text not null
);

# TABELAS COM FK
create table if not exists JOGADOR(				# TELA 1
	id_jogador			int unsigned auto_increment primary key,
    i_usuario			int unsigned not null,
    
    xp					int default 0,			# Incrementa nível, porém opcional
    nivel				int default 0,
    i_raca				int unsigned,
    i_classe			int unsigned,
    i_tendencia			int unsigned,
    i_antecedente		int unsigned,
    pontos_vida			int default 10,		# Pontos de vida totais
    pontos_vida_atual	int default 0,
	pontos_vida_temporaria	int default 0,			# Pontos de vida temporários/não aparece, mas soma o pv
    proficiencia		int default 0,
    classe_armadura		int default 0,			# Somado CA da armadura com atributos e o bonus
	classe_armadura_bonus int default 0,
    iniciativa			int default 0,			# Puxa Mod. Destreza
    iniciativa_bonus	int default 0,			# Incrementa Iniciativa acima
	deslocamento		decimal(4,2) default 9.0,
    deslocamento_bonus	decimal(4,2) default 0.0,	# Incrementa o de cima
    deslocamento_agua	decimal(4,2) default 0.0,
    deslocamento_escalada decimal(4,2) default 0.0,
    deslocamento_voo	decimal(4,2) default 0.0,
    percepcao_passiva	int default 0,			# 10 + proeficiência percepção + mod. sabedoria
    
    # ATRIBUTOS
    forca				int default 0,
    mod_for				int default 0,
    destreza			int default 0,
    mod_des				int default 0,
    constituicao		int default 0,
    mod_con				int default 0,
    inteligencia		int default 0,
    mod_int				int default 0,
    sabedoria			int default 0,
    mod_sab				int default 0,
    carisma				int default 0,
    mod_car				int default 0,
    
    # PERÍCIAS
    atletismo_base		int default 0,			#FORÇA
    atletismo			int default 0,	# Mod. atributo + bônus
    acrobacia_base		int default 0,			#DESTREZA
    acrobacia			int default 0,
    furtividade_base	int default 0,
    furtividade			int default 0,
    prestidigitacao_base	int default 0,
    prestidigitacao		int default 0,
    arcanismo_base		int default 0,			#INTELIGÊNCIA
    arcanismo			int default 0,
    historia_base		int default 0,
    historia			int default 0,
    investigacao_base	int default 0,
    investigacao		int default 0,
    natureza_base		int default 0,
    natureza			int default 0,
    religiao_base		int default 0,
    religiao			int default 0,
    intuicao_base		int default 0,			#SABEDORIA
    intuicao			int default 0,
    lidar_animais_base	int default 0,
    lidar_animais		int default 0,
    medicina_base		int default 0,
    medicina			int default 0,
    percepcao_base		int default 0,
    percepcao			int default 0,
    sobrevivencia_base	int default 0,
    sobrevivencia		int default 0,
    atuacao_base		int default 0,			#CARISMA
    atuacao				int default 0,
    enganacao_base		int default 0,
    enganacao			int default 0,
    intimidacao_base	int default 0,
    intimidacao			int default 0,
    persuasao_base		int default 0,
    persuasao			int default 0,
    
    constraint foreign key (i_usuario) references USUARIO(id_usuario),
    constraint foreign key (i_raca) references RACAS(id_raca),
    constraint foreign key (i_classe) references CLASSES(id_classe),
    constraint foreign key (i_tendencia) references TENDENCIAS(id_tendencia),
    constraint foreign key (i_antecedente) references	ANTECEDENTES(id_antecedente)
);

create table if not exists ARMADURAS(
	id_armadura			int unsigned auto_increment primary key,
    tipo				varchar(30) not null unique,
    preco				int not null,
    i_moeda				int unsigned not null,
    ca					int not null,				#Somado com valor do modificador abaixo	|	CÁLCULO FEITO
    modificador			varchar(35) default '',			#Incrementa no valor de cima			|	MANUALMENTE
    requisito			varchar(8) default '',
    desvantagem			varchar(11) default '',
    peso				decimal(4,2) default 0.0,		# Botão para adicionar armadura personalizada
    
    constraint foreign key (i_moeda) references MOEDA(id_moeda)
);

create table if not exists EQUIPAMENTOS(
	id_item				int unsigned auto_increment primary key,
    item				varchar(50) not null unique,
    preco				int not null,
    i_moeda				int unsigned not null,
    peso				decimal(4,2) not null,
    
    constraint foreign key (i_moeda) references MOEDA(id_moeda)
);

create table if not exists FERRAMENTAS(
	id_ferramenta		int unsigned auto_increment primary key,
    ferramenta			varchar(55) not null,
    descricao_ferramenta varchar(150) default '',
    preco				int not null,
    i_moeda				int unsigned not null,
    peso				decimal(4,2) not null,
    
    constraint foreign key (i_moeda) references MOEDA(id_moeda)
);

create table if not exists CLASSES(
	id_classe			int unsigned auto_increment primary key,
	classe				varchar(30) not null unique,
    descricao_classe	varchar(200) not null,
    habilidade_primaria	varchar(30) not null,
    dado_vida			int unsigned not null,
    p_armas_armad		varchar(200) not null,
    pt_resistencia		varchar(30) not null,		#Proficiência em Teste de Resistência
    
    constraint foreign key (dado_vida) references DADOS(id_dado)
);

create table if not exists HABILIDADES_CLASSE(			#Habilidades de Classe
	id_habilidade_classe		int unsigned auto_increment primary key,
    i_classe					int unsigned not null,
    nome						varchar(55) not null unique,
    descricao_hab_classe		text not null,
    constraint foreign key (i_classe) references CLASSES (id_classe)
);

create table if not exists TRACO_PERSONALIDADE(
	id_traco			int unsigned auto_increment primary key,
    i_antecedente		int unsigned not null,
    descricao_traco		varchar(200) not null,
    constraint foreign key (i_antecedente) references ANTECEDENTES(id_antecedente)
);

create table if not exists IDEAIS(
	id_ideal			int unsigned auto_increment primary key,
    i_antecedente		int unsigned not null,
    descricao_ideal		varchar(300) not null,
    constraint foreign key (i_antecedente) references ANTECEDENTES(id_antecedente)
);

create table if not exists VINCULOS(
	id_vinculo			int unsigned auto_increment primary key,
    i_antecedente		int unsigned not null,
    descricao_vinculo	varchar(300) not null,
    constraint foreign key (i_antecedente) references ANTECEDENTES(id_antecedente)
);

create table if not exists DEFEITOS(
	id_defeito			int unsigned auto_increment primary key,
    i_antecedente		int unsigned not null,
    descricao_defeito	varchar(300) not null,
    constraint foreign key (i_antecedente) references ANTECEDENTES(id_antecedente)
);

create table if not exists ARQUETIPOS(
	id_arquetipo		int unsigned auto_increment primary key,
    i_classe			int unsigned not null,
    titulo				varchar(50) not null unique,
    descricao_arquetipo	text not null,
    constraint foreign key (i_classe) references CLASSES(id_classe)
);

create table if not exists HABILIDADES_RACA(			#Habilidades de Raça
	id_habilidade_raca	int unsigned auto_increment primary key,
    i_raca				int unsigned not null,
    nome				varchar(60) not null unique,
    descricao_hab_raca	text not null,
    constraint foreign key (i_raca) references RACAS(id_raca)
);

create table if not exists CLASSES_MAGIA(			# isso aqui liga classes em magias
	id_ligacao			int unsigned auto_increment primary key,
	i_magia				int unsigned not null,
	i_classe			int unsigned not null,
	i_habilidade		int unsigned not null,
	
	constraint foreign key (i_magia) references GLOSSARIO_MAGIAS(id_magia),
	constraint foreign key (i_classe) references CLASSES(id_classe),
	constraint foreign key (i_habilidade) references HAB_MAGIA(id_habilidade)
);

create table if not exists MAGIAS_PERSONAGEM(
	id_registro			int unsigned auto_increment primary key,
	tipo				varchar(20) default '',			# magia ou truque
	i_jogador			int unsigned not null,
    i_magia				int unsigned not null,
    i_classe			int unsigned not null,
    
    constraint foreign key (i_jogador) references JOGADOR(id_jogador),
    constraint foreign key (i_magia) references GLOSSARIO_MAGIAS(id_magia),
    constraint foreign key (i_classe) references CLASSES(id_classe)
);

create table if not exists DEPOSITO(				# Armazena apenas armaduras
	id_controle			int unsigned auto_increment primary key,
    i_armadura			int unsigned not null,
    quantidade			int default 0,
    constraint foreign key (i_armadura) references ARMADURAS (id_armadura)
);

create table if not exists ARMAS(
	id_arma				int unsigned auto_increment primary key,
    arma				varchar(50) not null unique,
    preco				int not null,
    moeda				char(2) not null,
	quantidade_dado		int default 1,
    i_dado_dano			int unsigned not null,
	i_dano				int unsigned not null,
    peso				decimal(4,2) not null,
    propriedades		varchar(65) default '----',
    constraint foreign key (i_dado_dano) references DADOS(id_dado),
    constraint foreign key (i_dano) references TIPO_DANO(id_dano)
);

create table if not exists ARSENAL(				# Armazena apenas armas
	id_arsenal			int unsigned auto_increment primary key,
    i_arma				int unsigned not null,
    quantidade			int default 0,
    constraint foreign key (i_arma) references ARMAS(id_arma)
);

create table if not exists MOCHILA(				# Armazena apenas itens da tabela de equipamentos
	id_tralhas			int unsigned auto_increment primary key,
    i_item				int unsigned not null,
    quantidade			int default 0,
    constraint foreign key (i_item) references EQUIPAMENTOS(id_item)
);

create table if not exists UTILITARIOS(			# Armazena apenas itens da tabela de ferramentas
	id_utilitario		int unsigned auto_increment primary key,
    i_ferramenta		int unsigned not null,
    quantidade			int default 0,
    constraint foreign key (i_ferramenta) references FERRAMENTAS(id_ferramenta)
);

create table if not exists TRANQUEIRAS(			# Armazena apenas itens da tabela de bugigangas
	id_tranqueira		int unsigned auto_increment primary key,
    i_bugiganga			int unsigned not null,
    quantidade			int default 0,
    constraint foreign key (i_bugiganga) references BUGIGANGAS(id_bugiganga)
);



create table if not exists DETALHES_PERSONAGEM(				# TELA 2
	id_detalhes				int unsigned auto_increment primary key,
	i_jogador				int unsigned not null,
	i_habilidade_classe		int unsigned default null,
    i_habilidade_raca		int unsigned default null,
    i_arquetipo				int unsigned default null,
    i_talento				int unsigned default null,
    i_idioma				int unsigned default null,
    i_p_arma				int unsigned default null,		# Proficiência em Armas
	i_p_armadura			int unsigned default null,		# Proficiência em Armadura
    i_p_ferramenta			int unsigned default null,		# Proficiência em Ferramentas
    constraint foreign key (i_jogador) references JOGADOR(id_jogador),
    constraint foreign key (i_habilidade_classe) references HABILIDADES_CLASSE(id_habilidade_classe),
    constraint foreign key (i_habilidade_raca) references HABILIDADES_RACA(id_habilidade_raca),
    constraint foreign key (i_arquetipo) references ARQUETIPOS(id_arquetipo),
    constraint foreign key (i_talento) references TALENTOS(id_talento),
    constraint foreign key (i_idioma) references IDIOMAS(id_idioma),
    constraint foreign key (i_p_arma) references ARMAS(id_arma),
    constraint foreign key (i_p_armadura) references ARMADURAS(id_armadura),
    constraint foreign key (i_p_ferramenta) references FERRAMENTAS (id_ferramenta)
);

create table if not exists CARACTERISTICAS(		# TELA 3
	id_caracteristica		int unsigned auto_increment primary key,
    i_jogador				int unsigned not null,
	foto					varchar(200) default "",	#vai salvar o caminho da imagem não a imagem
    idade					int default 0,
    peso					decimal(5,2) default 0.0,
    cabelos					varchar(40) default '----',
    olhos					varchar(40) default '----',
    pele					varchar(40) default '----',
	caracteristica_personalizada    text default '',
    i_traco_personalidade	int unsigned,
    i_ideal					int unsigned,
    i_vinculo				int unsigned,
    i_defeito				int unsigned,
    historia				text default '',
    aliados_org				text default '',
    tesouro					text default '',
    constraint foreign key (i_jogador) references JOGADOR(id_jogador),
    constraint foreign key (i_traco_personalidade) references TRACO_PERSONALIDADE(id_traco),
    constraint foreign key (i_ideal) references IDEAIS(id_ideal),
    constraint foreign key (i_vinculo) references VINCULOS(id_vinculo),
    constraint foreign key (i_defeito) references DEFEITOS(id_defeito)
);

create table if not exists INVENTARIO(
	id_inventario	int unsigned auto_increment primary key,
    i_jogador				int unsigned not null,
	# RIQUEZA
    cobre			int default 0,
    prata			int default 0,
    electro			int default 0,
    ouro			int default 0,
    platina			int default 0,
    i_deposito		int unsigned,		# Armazena armaduras
    i_arsenal		int unsigned,		# Armazena armas
    i_mochila		int unsigned,		# Armazena equipamentos
    i_utilitario	int unsigned,		# Armazena ferramentas
    i_tranqueiras	int unsigned,		# Armazena bugigangas
    constraint foreign key (i_jogador) references JOGADOR(id_jogador),
    constraint foreign key (i_deposito) references DEPOSITO(id_controle),
    constraint foreign key (i_arsenal) references ARSENAL(id_arsenal),
    constraint foreign key (i_mochila) references MOCHILA(id_tralhas),
    constraint foreign key (i_utilitario) references UTILITARIOS(id_utilitario),
    constraint foreign key (i_tranqueiras) references TRANQUEIRAS(id_tranqueira)
);

create table if not exists GRIMORIO(		# TELA 5
	id_grimorio		int unsigned auto_increment primary key,
    i_jogador				int unsigned not null,
	i_habilidade_chave		int unsigned,			# ATRIBUTO CHAVE USADO NA MAGIA
    i_magia			int unsigned,
    uso1_max		int default 0,		#SLOT MAGIA LVL 1
    uso1_atual		int default 0,
    uso2_max		int default 0,		#SLOT MAGIA LVL 2
    uso2_atual		int default 0,
    uso3_max		int default 0,		#SLOT MAGIA LVL 3
    uso3_atual		int default 0,
	uso4_max		int default 0,		#SLOT MAGIA LVL 4
    uso4_atual		int default 0,
    uso5_max		int default 0,		#SLOT MAGICA LVL 5
    uso5_atual		int default 0,
    uso6_max		int default 0,		#SLOT MAGIA LVL 6
    uso6_atual		int default 0,
    uso7_max		int default 0,		#SLOT MAGIA LVL 7
    uso7_atual		int default 0,
    uso8_max		int default 0,		#SLOT MAGIA LVL 8
    uso8_atual		int default 0,
    uso9_max		int default 0,		#SLOT LVL 9
    uso9_atual		int default 0,
    constraint foreign key (i_jogador) references JOGADOR(id_jogador),
    constraint foreign key (i_habilidade_chave) references HAB_MAGIA(id_habilidade),
    constraint foreign key (i_magia) references GLOSSARIO_MAGIAS (id_magia)
);