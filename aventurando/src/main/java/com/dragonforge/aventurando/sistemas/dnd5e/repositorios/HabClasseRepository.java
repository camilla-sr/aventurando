package com.dragonforge.aventurando.sistemas.dnd5e.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.models.HabilidadeClasse;

public interface HabClasseRepository extends CrudRepository<HabilidadeClasse, Integer>{
	Optional<HabilidadeClasse> findById(Integer id);
	Iterable<HabilidadeClasse> findAll();
}