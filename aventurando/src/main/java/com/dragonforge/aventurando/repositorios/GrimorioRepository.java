package com.dragonforge.aventurando.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.models.Grimorio;

public interface GrimorioRepository extends CrudRepository<Grimorio, Integer>{
	Optional<Grimorio> findById(Integer id);
	Iterable<Grimorio> findAll();
}
