package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Caracteristicas;

@Component
public class CaracteristicaStrategy implements FormularioStrategy{
	@Override public String getTipoComponente() { return "caracteristicas"; }
	@Override public Object getEntidadeVazia() { return new Caracteristicas(); }
	@Override public String getEndpoint() {return "/caracteristica-api"; }
}