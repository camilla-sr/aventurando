package com.dragonforge.aventurando.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.models.HabilidadeRaca;

public interface HabRacaRepository extends CrudRepository<HabilidadeRaca, Integer>{
	Optional<HabilidadeRaca> findById(Integer id);
	Iterable<HabilidadeRaca> findAll();
}
