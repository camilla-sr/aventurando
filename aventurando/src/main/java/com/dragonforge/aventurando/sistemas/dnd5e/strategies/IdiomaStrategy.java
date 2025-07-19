package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Idioma;

@Component
public class IdiomaStrategy implements FormularioStrategy{
	@Override public String getTipoComponente() { return "idiomas"; }
	@Override public Object getEntidadeVazia() { return new Idioma(); }
	@Override public String getEndpoint() {return "/idioma-api"; }
}