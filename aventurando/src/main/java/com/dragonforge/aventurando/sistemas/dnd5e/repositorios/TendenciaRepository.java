package com.dragonforge.aventurando.sistemas.dnd5e.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Tendencia;

public interface TendenciaRepository extends CrudRepository<Tendencia, Integer>{
	Optional<Tendencia> findById(Integer id);
	Iterable<Tendencia> findAll();
}