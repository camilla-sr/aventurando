package com.dragonforge.aventurando.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.models.Ferramenta;

public interface FerramentaRepository extends CrudRepository<Ferramenta, Integer>{
	Optional<Ferramenta> findById(Integer id);
	Iterable<Ferramenta> findAll();
}