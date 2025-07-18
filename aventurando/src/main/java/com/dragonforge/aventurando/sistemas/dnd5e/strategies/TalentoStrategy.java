package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Talento;

@Component
public class TalentoStrategy implements FormularioStrategy{
	@Override
	public String getTipoComponente() { return "talentos"; }
	@Override
	public Object getEntidadeVazia() { return new Talento(); }
}