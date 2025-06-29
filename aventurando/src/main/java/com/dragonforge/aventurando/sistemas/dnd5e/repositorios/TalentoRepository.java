package com.dragonforge.aventurando.sistemas.dnd5e.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Talento;

public interface TalentoRepository extends CrudRepository<Talento, Integer>{
	Optional<Talento> findById(Integer id);
	Iterable<Talento> findAll();
}