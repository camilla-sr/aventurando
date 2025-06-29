package com.dragonforge.aventurando.sistemas.dnd5e.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Equipamento;

public interface EquipamentoRepository extends CrudRepository<Equipamento, Integer>{
	Optional<Equipamento> findById(Integer id);
	Iterable<Equipamento> findAll();
}