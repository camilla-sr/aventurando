package com.dragonforge.aventurando.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.models.Arquetipo;

public interface ArquetipoRepository extends CrudRepository<Arquetipo, Integer>{
	Optional<Arquetipo> findById(Integer id);
	Iterable<Arquetipo> findAll();
}