package com.dragonforge.aventurando.repositorios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.models.TipoDano;

public interface DanoRepository extends CrudRepository<TipoDano, Integer>{
	Optional<TipoDano> findById(Integer id);
	Iterable<TipoDano> findAll();
}
