package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.GlossarioMagias;

@Component
public class GlossarioStrategy implements FormularioStrategy{
	@Override
	public String getTipoComponente() { return "magias"; }
	@Override
	public Object getEntidadeVazia() { return new GlossarioMagias(); }
}