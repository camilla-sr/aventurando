package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.HabilidadeMagia;

@Component
public class HabMagiaStrategy implements FormularioStrategy{
	@Override public String getTipoComponente() { return "hab_magias"; }
	@Override public Object getEntidadeVazia() { return new HabilidadeMagia(); }
	@Override public String getEndpoint() {return "/habilidademagia-api"; }
}