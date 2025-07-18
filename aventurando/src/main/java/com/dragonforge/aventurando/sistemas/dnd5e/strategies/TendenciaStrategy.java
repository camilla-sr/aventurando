package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Tendencia;

@Component
public class TendenciaStrategy implements FormularioStrategy{
	@Override
	public String getTipoComponente() { return "tendencias"; }
	@Override
	public Object getEntidadeVazia() { return new Tendencia(); }
}