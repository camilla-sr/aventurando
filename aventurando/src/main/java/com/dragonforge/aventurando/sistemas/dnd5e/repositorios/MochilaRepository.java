package com.dragonforge.aventurando.sistemas.dnd5e.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Mochila;

public interface MochilaRepository extends CrudRepository<Mochila, Integer>{
	Optional<Mochila> findById(Integer id);
	Iterable<Mochila> findAll();
}