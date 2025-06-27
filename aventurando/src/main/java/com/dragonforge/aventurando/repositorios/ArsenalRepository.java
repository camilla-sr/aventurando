package com.dragonforge.aventurando.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.models.Arsenal;

public interface ArsenalRepository extends CrudRepository<Arsenal, Integer>{
	Optional<Arsenal> findById(Integer id);
	Iterable<Arsenal> findAll();
}