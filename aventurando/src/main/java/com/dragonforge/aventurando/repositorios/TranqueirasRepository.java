package com.dragonforge.aventurando.repositorios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dragonforge.aventurando.models.Tranqueiras;

public interface TranqueirasRepository extends CrudRepository<Tranqueiras, Integer>{
	Optional<Tranqueiras> findById(Integer id);
	Iterable<Tranqueiras> findAll();
}
