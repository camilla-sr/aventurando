package com.dragonforge.aventurando.sistemas.dnd5e.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Arsenal;

public interface ArsenalRepository extends CrudRepository<Arsenal, Integer>{
	Optional<Arsenal> findById(Integer id);
	Iterable<Arsenal> findAll();
}