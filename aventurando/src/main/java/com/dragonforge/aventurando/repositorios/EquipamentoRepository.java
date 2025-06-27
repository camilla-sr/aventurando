package com.dragonforge.aventurando.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.models.Equipamento;

public interface EquipamentoRepository extends CrudRepository<Equipamento, Integer>{
	Optional<Equipamento> findById(Integer id);
	Iterable<Equipamento> findAll();
}