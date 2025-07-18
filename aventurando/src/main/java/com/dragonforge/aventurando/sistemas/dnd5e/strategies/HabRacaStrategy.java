package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.HabilidadeRaca;

@Component
public class HabRacaStrategy implements FormularioStrategy{
	@Override
	public String getTipoComponente() { return "hab_raca"; }
	@Override
	public Object getEntidadeVazia() { return new HabilidadeRaca(); }
}