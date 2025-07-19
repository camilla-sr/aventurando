package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Bugiganga;

@Component
public class BugigangaStrategy implements FormularioStrategy{
	@Override public String getTipoComponente() { return "bugigangas"; }
	@Override public Object getEntidadeVazia() { return new Bugiganga(); }
	@Override public String getEndpoint() {return "/bugiganga-api"; }
}