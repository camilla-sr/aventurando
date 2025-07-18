package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Defeito;

@Component
public class DefeitoStrategy implements FormularioStrategy{
	@Override
	public String getTipoComponente() { return "defeitos"; }
	@Override
	public Object getEntidadeVazia() { return new Defeito(); }
}
