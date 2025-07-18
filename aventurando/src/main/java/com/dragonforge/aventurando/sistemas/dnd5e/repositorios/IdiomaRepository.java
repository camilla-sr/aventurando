package com.dragonforge.aventurando.sistemas.dnd5e.repositorios;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Idioma;

public interface IdiomaRepository extends CrudRepository<Idioma, Integer>{
	Optional<Idioma> findById(Integer id);
	List<Idioma> findAll();
}