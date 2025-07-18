package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Dado;

@Component
public class DadoStrategy implements FormularioStrategy{
	@Override
	public String getTipoComponente() { return "dados"; }
	@Override
	public Object getEntidadeVazia() { return new Dado(); }
}