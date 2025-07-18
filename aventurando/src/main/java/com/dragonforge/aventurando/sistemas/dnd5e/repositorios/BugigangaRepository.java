package com.dragonforge.aventurando.sistemas.dnd5e.repositorios;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Bugiganga;

public interface BugigangaRepository extends CrudRepository<Bugiganga, Integer>{
	Optional<Bugiganga> findById(Integer id);
	List<Bugiganga> findAll();
}