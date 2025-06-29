package com.dragonforge.aventurando.sistemas.dnd5e.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.models.HabilidadeRaca;

public interface HabRacaRepository extends CrudRepository<HabilidadeRaca, Integer>{
	Optional<HabilidadeRaca> findById(Integer id);
	Iterable<HabilidadeRaca> findAll();
}