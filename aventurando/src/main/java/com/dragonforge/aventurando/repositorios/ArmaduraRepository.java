package com.dragonforge.aventurando.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.models.Armadura;

public interface ArmaduraRepository extends CrudRepository<Armadura, Integer>{
	Optional<Armadura> findById(Integer id);
	Iterable<Armadura> findAll();
}