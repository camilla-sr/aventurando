package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Arsenal;

@Component
public class ArsenalStrategy implements FormularioStrategy{
	@Override
	public String getTipoComponente() { return "arsenal"; }
	@Override
	public Object getEntidadeVazia() { return new Arsenal(); }
}