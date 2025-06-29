package com.dragonforge.aventurando.sistemas.dnd5e.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Ferramenta;

public interface FerramentaRepository extends CrudRepository<Ferramenta, Integer>{
	Optional<Ferramenta> findById(Integer id);
	Iterable<Ferramenta> findAll();
}