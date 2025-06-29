package com.dragonforge.aventurando.sistemas.dnd5e.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Classe;

public interface ClasseRepository extends CrudRepository<Classe, Integer>{
	Optional<Classe> findById(Integer id);
	Iterable<Classe> findAll();
}