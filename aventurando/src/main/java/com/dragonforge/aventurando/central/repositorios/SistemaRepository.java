package com.dragonforge.aventurando.central.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.central.models.Sistema;

public interface SistemaRepository extends CrudRepository<Sistema, Integer>{
	Optional<Sistema> findById(Integer id);
	Iterable<Sistema> findAll();
}