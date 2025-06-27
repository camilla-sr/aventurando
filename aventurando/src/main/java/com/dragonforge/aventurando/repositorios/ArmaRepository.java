package com.dragonforge.aventurando.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.models.Arma;

public interface ArmaRepository extends CrudRepository<Arma, Integer>{
	Optional<Arma> findById(Integer id);
	Iterable<Arma> findAll();
}