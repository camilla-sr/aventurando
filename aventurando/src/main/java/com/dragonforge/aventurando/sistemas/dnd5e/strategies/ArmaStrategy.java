package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Arma;

@Component
public class ArmaStrategy implements FormularioStrategy{
	@Override
	public String getTipoComponente() { return "armas"; }
	
	@Override
	public Object getEntidadeVazia() { return new Arma(); }
}