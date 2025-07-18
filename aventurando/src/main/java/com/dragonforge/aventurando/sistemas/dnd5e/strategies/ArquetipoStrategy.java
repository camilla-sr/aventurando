package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Arquetipo;

@Component
public class ArquetipoStrategy implements FormularioStrategy{
	@Override
	public String getTipoComponente() { return "arquetipos"; }
	@Override
	public Object getEntidadeVazia() { return new Arquetipo(); }
}
