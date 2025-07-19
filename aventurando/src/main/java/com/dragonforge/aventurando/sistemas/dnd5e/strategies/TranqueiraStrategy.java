package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Tranqueiras;

@Component
public class TranqueiraStrategy implements FormularioStrategy{
	@Override public String getTipoComponente() { return "tranqueiras"; }
	@Override public Object getEntidadeVazia() { return new Tranqueiras(); }
	@Override public String getEndpoint() {return "/tranqueiras-api"; }
}