package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.DetalhesPersonagem;

@Component
public class DetalheStrategy implements FormularioStrategy{
	@Override
	public String getTipoComponente() { return "detalhes_personagem"; }
	@Override
	public Object getEntidadeVazia() { return new DetalhesPersonagem(); }
}