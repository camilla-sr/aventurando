package com.dragonforge.aventurando.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.models.Utilitarios;

public interface UtilitariosRepository extends CrudRepository<Utilitarios, Integer>{
	Optional<Utilitarios> findById(Integer id);
	
	Iterable<Utilitarios> findAll();
}
