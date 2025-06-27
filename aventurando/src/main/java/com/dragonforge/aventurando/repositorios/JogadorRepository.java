package com.dragonforge.aventurando.repositorios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dragonforge.aventurando.models.Jogador;

public interface JogadorRepository extends CrudRepository<Jogador, Integer>{
	Optional<Jogador> findById(Integer id);
	Iterable<Jogador> findAll();
}
