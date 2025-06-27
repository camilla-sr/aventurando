package com.dragonforge.aventurando.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.models.GlossarioMagias;

public interface GlossarioRepository extends CrudRepository<GlossarioMagias, Integer>{
	Optional<GlossarioMagias> findById(Integer id);
	Iterable<GlossarioMagias> findAll();
}