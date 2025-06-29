package com.dragonforge.aventurando.sistemas.dnd5e.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Dado;

public interface DadoRepository extends CrudRepository<Dado, Integer>{
	Optional<Dado> findById(Integer id);
	Iterable<Dado> findAll();
}