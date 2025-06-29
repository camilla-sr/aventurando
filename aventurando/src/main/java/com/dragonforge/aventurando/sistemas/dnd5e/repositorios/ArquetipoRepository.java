package com.dragonforge.aventurando.sistemas.dnd5e.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Arquetipo;

public interface ArquetipoRepository extends CrudRepository<Arquetipo, Integer>{
	Optional<Arquetipo> findById(Integer id);
	Iterable<Arquetipo> findAll();
}