package com.dragonforge.aventurando.sistemas.dnd5e.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Caracteristicas;

public interface CaracteristicaRepository extends CrudRepository<Caracteristicas, Integer>{
	Optional<Caracteristicas> findById(Integer id);
	Iterable<Caracteristicas> findAll();
}