package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.ClasseMagica;

@Component
public class ClasseMagicaStrategy implements FormularioStrategy{
	@Override
	public String getTipoComponente() { return "classe_magica"; }
	@Override
	public Object getEntidadeVazia() { return new ClasseMagica(); }
}