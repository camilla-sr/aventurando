package com.dragonforge.aventurando.sistemas.dnd5e.repositorios;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.models.ClasseMagica;

public interface ClasseMagicaRepository extends CrudRepository<ClasseMagica, Integer>{
	Optional<ClasseMagica> findById(Integer id);
	List<ClasseMagica> findAll();
}