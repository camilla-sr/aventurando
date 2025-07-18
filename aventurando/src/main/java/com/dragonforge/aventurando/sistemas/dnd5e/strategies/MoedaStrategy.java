package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Moeda;

@Component
public class MoedaStrategy implements FormularioStrategy{
	@Override
	public String getTipoComponente() { return "moedas"; }
	@Override
	public Object getEntidadeVazia() { return new Moeda(); }
}