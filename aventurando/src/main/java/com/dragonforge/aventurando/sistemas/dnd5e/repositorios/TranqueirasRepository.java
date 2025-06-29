package com.dragonforge.aventurando.sistemas.dnd5e.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Tranqueiras;

public interface TranqueirasRepository extends CrudRepository<Tranqueiras, Integer>{
	Optional<Tranqueiras> findById(Integer id);
	Iterable<Tranqueiras> findAll();
}