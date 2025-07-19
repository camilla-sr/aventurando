package com.dragonforge.aventurando.central.services;

import com.dragonforge.aventurando.central.util.FormField;
import com.dragonforge.aventurando.sistemas.dnd5e.models.*;
import com.dragonforge.aventurando.sistemas.dnd5e.repositorios.*;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FormGerador {
    @Autowired private AntecedenteRepository antec;
    @Autowired private ArmaRepository arma;
    @Autowired private ArmaduraRepository armadura;
    @Autowired private ArquetipoRepository arque;
    @Autowired private BugigangaRepository bugi;
    @Autowired private ClasseRepository classe;
    @Autowired private DadoRepository dice;
    @Autowired private DefeitoRepository defeito;
    @Autowired private EquipamentoRepository equip;
    @Autowired private FerramentaRepository tool;
    @Autowired private GlossarioRepository magias;
    @Autowired private HabClasseRepository hab_classe;
    @Autowired private HabMagiaRepository hab_magica;
    @Autowired private HabRacaRepository hab_raca;
    @Autowired private IdealRepository ideal;
    @Autowired private IdiomaRepository idioma;
    @Autowired private MoedaRepository moeda;
    @Autowired private RacaRepository raca;
    @Autowired private TalentoRepository talent;
    @Autowired private TendenciaRepository tend;
    @Autowired private DanoRepository dano;
    @Autowired private TracoRepository traco;
    @Autowired private VinculoRepository vinculo;

    public List<FormField> generateFieldsFor(Object entity) {
        List<FormField> formFields = new ArrayList<>();
        Field[] fields = entity.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.getName().equals("id") || field.getName().equals("serialVersionUID")) {
                continue;
            }

            if (field.isAnnotationPresent(ManyToOne.class)) {
                FormField formField = new FormField(field.getName(), toLabel(field.getName()), "select", true);
                formField.setOptions(getOptionsFor(field.getType()));
                formFields.add(formField);
            } else {
                FormField formField = new FormField(field.getName(), toLabel(field.getName()), "text", true);
                formFields.add(formField);
            }
        }
        return formFields;
    }

    private String toLabel(String fieldName) {
        // Transforma "nomeDaClasse" em "Nome Da Classe"
        String spaced = fieldName.replaceAll("([A-Z])", " $1");
        return Character.toUpperCase(spaced.charAt(0)) + spaced.substring(1);
    }

    private Map<Object, String> getOptionsFor(Class<?> fieldType) {
        if (fieldType == Antecedente.class) {
            return antec.findAll().stream().collect(Collectors.toMap(Antecedente::getIdAntecedente, Antecedente::getAntecedente));
        }
        if (fieldType == Arma.class) {
            return arma.findAll().stream().collect(Collectors.toMap(Arma::getIdArma, Arma::getArma));
        }
        if (fieldType == Armadura.class) {
            return armadura.findAll().stream().collect(Collectors.toMap(Armadura::getIdArmadura, Armadura::getTipo));
        }
        if (fieldType == Arquetipo.class) {
            return arque.findAll().stream().collect(Collectors.toMap(Arquetipo::getIdArquetipo, Arquetipo::getTitulo));
        }
        if (fieldType == Bugiganga.class) {
            return bugi.findAll().stream().collect(Collectors.toMap(Bugiganga::getIdBugiganga, Bugiganga::getDescricaoBugiganga));
        }
        if (fieldType == Classe.class) {
            return classe.findAll().stream().collect(Collectors.toMap(Classe::getIdClasse, Classe::getClasse));
        }
        if (fieldType == Dado.class) {
            return dice.findAll().stream().collect(Collectors.toMap(Dado::getIdDado, Dado::getTipo));
        }
        if (fieldType == Defeito.class) {
            return defeito.findAll().stream().collect(Collectors.toMap(Defeito::getIdDefeito, Defeito::getDescricaoDefeito));
        }
        if (fieldType == Equipamento.class) {
            return equip.findAll().stream().collect(Collectors.toMap(Equipamento::getIdItem, Equipamento::getItem));
        }
        if (fieldType == Ferramenta.class) {
            return tool.findAll().stream().collect(Collectors.toMap(Ferramenta::getIdFerramenta, Ferramenta::getFerramenta));
        }
        if (fieldType == GlossarioMagias.class) { // Magias
            return magias.findAll().stream().collect(Collectors.toMap(GlossarioMagias::getIdMagia, GlossarioMagias::getMagia));
        }
        if (fieldType == HabilidadeClasse.class) {
            return hab_classe.findAll().stream().collect(Collectors.toMap(HabilidadeClasse::getIdHabilidadeClasse, HabilidadeClasse::getNome));
        }
        if (fieldType == HabilidadeMagia.class) {
            return hab_magica.findAll().stream().collect(Collectors.toMap(HabilidadeMagia::getIdHabilidade, HabilidadeMagia::getHabilidadeChave));
        }
        if (fieldType == HabilidadeRaca.class) {
            return hab_raca.findAll().stream().collect(Collectors.toMap(HabilidadeRaca::getIdHabilidadeRaca, HabilidadeRaca::getNome));
        }
        if (fieldType == Ideal.class) {
            return ideal.findAll().stream().collect(Collectors.toMap(Ideal::getIdIdeal, Ideal::getDescricaoIdeal));
        }
        if (fieldType == Idioma.class) {
            return idioma.findAll().stream().collect(Collectors.toMap(Idioma::getIdIdioma, Idioma::getDescricaoIdioma));
        }
        if (fieldType == Moeda.class) {
            return moeda.findAll().stream().collect(Collectors.toMap(Moeda::getIdMoeda, Moeda::getMoeda));
        }
        if (fieldType == Raca.class) {
            return raca.findAll().stream().collect(Collectors.toMap(Raca::getIdRaca, Raca::getRaca));
        }
        if (fieldType == Talento.class) {
            return talent.findAll().stream().collect(Collectors.toMap(Talento::getIdTalento, Talento::getTalento));
        }
        if (fieldType == Tendencia.class) {
            return tend.findAll().stream().collect(Collectors.toMap(Tendencia::getIdTendencia, Tendencia::getTendencia));
        }
        if (fieldType == TipoDano.class) {
            return dano.findAll().stream().collect(Collectors.toMap(TipoDano::getIdDano, TipoDano::getDescricaoDano));
        }
        if (fieldType == TracoPersonalidade.class) {
            return traco.findAll().stream().collect(Collectors.toMap(TracoPersonalidade::getIdTraco, TracoPersonalidade::getDescricaoTraco));
        }
        if (fieldType == Vinculo.class) {
            return vinculo.findAll().stream().collect(Collectors.toMap(Vinculo::getIdVinculo, Vinculo::getDescricaoVinculo));
        }
        return null; // Retorna nulo se não houver um repositório mapeado
    }
}