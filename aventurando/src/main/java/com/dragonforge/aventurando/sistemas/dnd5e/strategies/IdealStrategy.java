package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Ideal;

@Component
public class IdealStrategy implements FormularioStrategy{
	@Override public String getTipoComponente() { return "ideais"; }
	@Override public Object getEntidadeVazia() { return new Ideal(); }
	@Override public String getEndpoint() {return "/ideal-api"; }
}