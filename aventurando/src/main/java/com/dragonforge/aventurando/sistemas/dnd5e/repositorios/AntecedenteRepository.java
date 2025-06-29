package com.dragonforge.aventurando.sistemas.dnd5e.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Antecedente;

public interface AntecedenteRepository extends CrudRepository<Antecedente, Integer>{
	Optional<Antecedente> findById(Integer id);
	Iterable<Antecedente> findAll();
}