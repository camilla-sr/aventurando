package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Inventario;

@Component
public class InventarioStrategy implements FormularioStrategy{
	@Override public String getTipoComponente() { return "inventario"; }
	@Override public Object getEntidadeVazia() { return new Inventario(); }
	@Override public String getEndpoint() {return "/inventario-api"; }
}