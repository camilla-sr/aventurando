package com.dragonforge.aventurando.sistemas.dnd5e.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.models.HabilidadeMagia;

public interface HabMagiaRepository extends CrudRepository<HabilidadeMagia, Integer>{
	Optional<HabilidadeMagia> findById(Integer id);
	Iterable<HabilidadeMagia> findAll();
}