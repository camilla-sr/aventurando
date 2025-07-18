package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Antecedente;

@Component
public class AntecedenteStrategy implements FormularioStrategy{
	@Override
	public String getTipoComponente() { return "antecedentes"; }
	@Override
	public Object getEntidadeVazia() { return new Antecedente(); }
}
