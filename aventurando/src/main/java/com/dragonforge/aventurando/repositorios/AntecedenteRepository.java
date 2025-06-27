package com.dragonforge.aventurando.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.models.Antecedente;

public interface AntecedenteRepository extends CrudRepository<Antecedente, Integer>{
	Optional<Antecedente> findById(Integer id);
	Iterable<Antecedente> findAll();
}