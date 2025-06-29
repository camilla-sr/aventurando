package com.dragonforge.aventurando.sistemas.dnd5e.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.models.TracoPersonalidade;

public interface TracoRepository extends CrudRepository<TracoPersonalidade, Integer>{
	Optional<TracoPersonalidade> findById(Integer id);
	Iterable<TracoPersonalidade> findAll();
}