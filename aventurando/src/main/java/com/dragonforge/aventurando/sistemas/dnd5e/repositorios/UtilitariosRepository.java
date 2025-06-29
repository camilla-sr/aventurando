package com.dragonforge.aventurando.sistemas.dnd5e.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Utilitarios;

public interface UtilitariosRepository extends CrudRepository<Utilitarios, Integer>{
	Optional<Utilitarios> findById(Integer id);
	
	Iterable<Utilitarios> findAll();
}