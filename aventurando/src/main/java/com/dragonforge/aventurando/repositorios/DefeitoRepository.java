package com.dragonforge.aventurando.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.models.Defeito;

public interface DefeitoRepository extends CrudRepository<Defeito, Integer>{
	Optional<Defeito> findById(Integer id);
	Iterable<Defeito> findAll();
}