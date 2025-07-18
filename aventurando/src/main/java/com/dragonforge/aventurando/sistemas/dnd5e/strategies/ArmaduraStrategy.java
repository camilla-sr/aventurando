package com.dragonforge.aventurando.sistemas.dnd5e.strategies;
import org.springframework.stereotype.Component;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Armadura;

@Component
public class ArmaduraStrategy implements FormularioStrategy{
	@Override
	public String getTipoComponente() { return "armaduras"; }
	@Override
	public Object getEntidadeVazia() { return new Armadura(); }
}