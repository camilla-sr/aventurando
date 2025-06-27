package com.dragonforge.aventurando.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.models.Classe;

public interface ClasseRepository extends CrudRepository<Classe, Integer>{
	Optional<Classe> findById(Integer id);
	Iterable<Classe> findAll();
}