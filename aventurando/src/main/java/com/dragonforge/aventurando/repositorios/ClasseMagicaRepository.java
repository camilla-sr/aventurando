package com.dragonforge.aventurando.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.models.ClasseMagica;

public interface ClasseMagicaRepository extends CrudRepository<ClasseMagica, Integer>{
	Optional<ClasseMagica> findById(Integer id);
	Iterable<ClasseMagica> findAll();
}