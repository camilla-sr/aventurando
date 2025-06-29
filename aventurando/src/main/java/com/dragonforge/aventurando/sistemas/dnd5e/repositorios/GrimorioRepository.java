package com.dragonforge.aventurando.sistemas.dnd5e.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Grimorio;

public interface GrimorioRepository extends CrudRepository<Grimorio, Integer>{
	Optional<Grimorio> findById(Integer id);
	Iterable<Grimorio> findAll();
}
