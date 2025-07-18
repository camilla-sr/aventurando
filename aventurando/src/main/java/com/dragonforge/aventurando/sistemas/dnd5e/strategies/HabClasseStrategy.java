package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.HabilidadeClasse;

@Component
public class HabClasseStrategy implements FormularioStrategy{
	@Override
	public String getTipoComponente() { return "hab_classe"; }
	@Override
	public Object getEntidadeVazia() { return new HabilidadeClasse(); }
}