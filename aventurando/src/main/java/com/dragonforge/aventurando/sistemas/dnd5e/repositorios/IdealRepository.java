package com.dragonforge.aventurando.sistemas.dnd5e.repositorios;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Ideal;

public interface IdealRepository extends CrudRepository<Ideal, Integer>{
	Optional<Ideal> findById(Integer id);
	List<Ideal> findAll();
}