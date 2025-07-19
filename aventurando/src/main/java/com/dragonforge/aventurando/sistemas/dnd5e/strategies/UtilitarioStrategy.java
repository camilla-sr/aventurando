package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Utilitarios;

@Component
public class UtilitarioStrategy implements FormularioStrategy{
	@Override public String getTipoComponente() { return "utilitarios"; }
	@Override public Object getEntidadeVazia() { return new Utilitarios(); }
	@Override public String getEndpoint() {return "/utilitarios-api"; }
}