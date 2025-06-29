package com.dragonforge.aventurando.sistemas.dnd5e.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Moeda;

public interface MoedaRepository extends CrudRepository<Moeda, Integer>{
	Optional<Moeda> findById(Integer id);
	Iterable<Moeda> findAll();
}