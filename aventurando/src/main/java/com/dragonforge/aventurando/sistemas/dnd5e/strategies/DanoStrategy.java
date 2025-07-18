package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.TipoDano;

@Component
public class DanoStrategy implements FormularioStrategy{
	@Override
	public String getTipoComponente() { return "danos"; }
	@Override
	public Object getEntidadeVazia() { return new TipoDano(); }
}