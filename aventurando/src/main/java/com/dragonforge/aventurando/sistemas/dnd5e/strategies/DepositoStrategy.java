package com.dragonforge.aventurando.sistemas.dnd5e.strategies;

import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Deposito;

@Component
public class DepositoStrategy implements FormularioStrategy{
	@Override
	public String getTipoComponente() { return "deposito"; }
	@Override
	public Object getEntidadeVazia() { return new Deposito(); }
}