package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Raca;

@Component
public class RacaStrategy implements FormularioStrategy{
	@Override public String getTipoComponente() { return "racas"; }
	@Override public Object getEntidadeVazia() { return new Raca(); }
	@Override public String getEndpoint() {return "/raca-api"; }
}