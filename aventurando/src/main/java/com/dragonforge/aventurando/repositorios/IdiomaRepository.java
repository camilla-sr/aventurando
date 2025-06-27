package com.dragonforge.aventurando.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.models.Idioma;

public interface IdiomaRepository extends CrudRepository<Idioma, Integer>{
	Optional<Idioma> findById(Integer id);
	Iterable<Idioma> findAll();
}
