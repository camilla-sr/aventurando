package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Vinculo;

@Component
public class VinculoStrategy implements FormularioStrategy{
	@Override public String getTipoComponente() { return "vinculos"; }
	@Override public Object getEntidadeVazia() { return new Vinculo(); }
	@Override public String getEndpoint() {return "/vinculo-api"; }
}