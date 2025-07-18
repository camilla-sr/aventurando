package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Ferramenta;

@Component
public class FerramentaStrategy implements FormularioStrategy{
	@Override
	public String getTipoComponente() { return "ferramentas"; }
	@Override
	public Object getEntidadeVazia() { return new Ferramenta(); }
}