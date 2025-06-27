package com.dragonforge.aventurando.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.models.Mochila;

public interface MochilaRepository extends CrudRepository<Mochila, Integer>{
	Optional<Mochila> findById(Integer id);
	Iterable<Mochila> findAll();
}
