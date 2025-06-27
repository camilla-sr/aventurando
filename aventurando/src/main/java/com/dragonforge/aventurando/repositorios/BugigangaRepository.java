package com.dragonforge.aventurando.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.models.Bugiganga;

public interface BugigangaRepository extends CrudRepository<Bugiganga, Integer>{
	Optional<Bugiganga> finById(Integer id);
	Iterable<Bugiganga> findAll();
}