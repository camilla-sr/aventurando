package com.dragonforge.aventurando.sistemas.dnd5e.repositorios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.models.DetalhesPersonagem;

public interface DetalhesRepository extends CrudRepository<DetalhesPersonagem, Integer>{
	Optional<DetalhesPersonagem> findById(Integer id);
	Iterable<DetalhesPersonagem> findAll();
}