package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.MagiasPersonagem;

@Component
public class MagiaPersonagemStrategy implements FormularioStrategy{
	@Override
	public String getTipoComponente() { return "magias_personagem"; }
	@Override
	public Object getEntidadeVazia() { return new MagiasPersonagem(); }
}