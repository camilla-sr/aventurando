package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Grimorio;

@Component
public class GrimorioStrategy implements FormularioStrategy{
	@Override
	public String getTipoComponente() { return "grimorio"; }
	@Override
	public Object getEntidadeVazia() { return new Grimorio(); }
}