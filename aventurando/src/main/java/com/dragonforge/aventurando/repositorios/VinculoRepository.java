package com.dragonforge.aventurando.repositorios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dragonforge.aventurando.models.Vinculo;

public interface VinculoRepository extends CrudRepository<Vinculo, Integer>{
	Optional<Vinculo> findVinculoById(Integer id);
	
	Iterable<Vinculo> findAll();
}
