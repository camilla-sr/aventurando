package com.dragonforge.aventurando.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.models.Dado;

public interface DadoRepository extends CrudRepository<Dado, Integer>{
	Optional<Dado> findById(Integer id);
	Iterable<Dado> findAll();
}