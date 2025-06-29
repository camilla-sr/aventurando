package com.dragonforge.aventurando.sistemas.dnd5e.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Arma;

public interface ArmaRepository extends CrudRepository<Arma, Integer>{
	Optional<Arma> findById(Integer id);
	Iterable<Arma> findAll();
}