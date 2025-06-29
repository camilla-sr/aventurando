package com.dragonforge.aventurando.sistemas.dnd5e.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Defeito;

public interface DefeitoRepository extends CrudRepository<Defeito, Integer>{
	Optional<Defeito> findById(Integer id);
	Iterable<Defeito> findAll();
}