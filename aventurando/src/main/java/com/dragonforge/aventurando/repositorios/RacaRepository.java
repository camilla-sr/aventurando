package com.dragonforge.aventurando.repositorios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dragonforge.aventurando.models.Raca;

public interface RacaRepository extends CrudRepository<Raca, Integer>{
	Optional<Raca> findById(Integer id);
	Iterable<Raca> findAll();
}
