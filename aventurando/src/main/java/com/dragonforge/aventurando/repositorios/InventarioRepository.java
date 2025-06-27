package com.dragonforge.aventurando.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.models.Inventario;

public interface InventarioRepository extends CrudRepository<Inventario, Integer>{
	Optional<Inventario> findById(Integer id);
	Iterable<Inventario> findAll();
}
