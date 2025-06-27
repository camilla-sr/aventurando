package com.dragonforge.aventurando.repositorios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dragonforge.aventurando.models.HabilidadeMagia;

public interface HabMagiaRepository extends CrudRepository<HabilidadeMagia, Integer>{
	Optional<HabilidadeMagia> findById(Integer id);
	Iterable<HabilidadeMagia> findAll();
}
