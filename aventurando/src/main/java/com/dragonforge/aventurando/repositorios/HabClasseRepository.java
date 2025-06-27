package com.dragonforge.aventurando.repositorios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dragonforge.aventurando.models.HabilidadeClasse;

public interface HabClasseRepository extends CrudRepository<HabilidadeClasse, Integer>{
	Optional<HabilidadeClasse> findById(Integer id);
	Iterable<HabilidadeClasse> findAll();
}
