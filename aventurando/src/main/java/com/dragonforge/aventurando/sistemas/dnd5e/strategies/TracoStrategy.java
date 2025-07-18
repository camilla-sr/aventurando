package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.TracoPersonalidade;

@Component
public class TracoStrategy implements FormularioStrategy{
	@Override
	public String getTipoComponente() { return "tracos"; }
	@Override
	public Object getEntidadeVazia() { return new TracoPersonalidade(); }
}