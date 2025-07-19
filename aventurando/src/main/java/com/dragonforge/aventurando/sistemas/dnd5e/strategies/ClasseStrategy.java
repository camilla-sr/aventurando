package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Classe;

@Component
public class ClasseStrategy implements FormularioStrategy{
	@Override public String getTipoComponente() { return "classes"; }
	@Override public Object getEntidadeVazia() { return new Classe(); }
	@Override public String getEndpoint() {return "/classe-api"; }
}