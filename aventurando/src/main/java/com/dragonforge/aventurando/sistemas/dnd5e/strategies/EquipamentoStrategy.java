package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Equipamento;

@Component
public class EquipamentoStrategy implements FormularioStrategy{
	@Override public String getTipoComponente() { return "equipamentos"; }
	@Override public Object getEntidadeVazia() { return new Equipamento(); }
	@Override public String getEndpoint() {return "/equipamento-api"; }
}