package com.dragonforge.aventurando.repositorios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dragonforge.aventurando.models.TracoPersonalidade;

public interface TracoRepository extends CrudRepository<TracoPersonalidade, Integer>{
	Optional<TracoPersonalidade> findById(Integer id);
	Iterable<TracoPersonalidade> findAll();
}
