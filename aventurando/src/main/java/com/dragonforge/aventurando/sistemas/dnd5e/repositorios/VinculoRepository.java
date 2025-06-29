package com.dragonforge.aventurando.sistemas.dnd5e.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Vinculo;

public interface VinculoRepository extends CrudRepository<Vinculo, Integer>{
	Optional<Vinculo> findById(Integer id);
	
	Iterable<Vinculo> findAll();
}