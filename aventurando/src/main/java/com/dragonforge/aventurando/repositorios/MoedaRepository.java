package com.dragonforge.aventurando.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.models.Moeda;

public interface MoedaRepository extends CrudRepository<Moeda, Integer>{
	Optional<Moeda> findById(Integer id);
	Iterable<Moeda> findAll();
}
