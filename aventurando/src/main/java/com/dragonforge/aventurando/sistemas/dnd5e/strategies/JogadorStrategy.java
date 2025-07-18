package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Jogador;

@Component
public class JogadorStrategy implements FormularioStrategy{
	@Override
	public String getTipoComponente() { return "jogador"; }
	@Override
	public Object getEntidadeVazia() { return new Jogador(); }
}