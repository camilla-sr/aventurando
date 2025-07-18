package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Mochila;

@Component
public class MochilaStrategy implements FormularioStrategy{
	@Override
	public String getTipoComponente() { return "mochila"; }
	@Override
	public Object getEntidadeVazia() { return new Mochila(); }
}