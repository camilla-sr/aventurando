package com.dragonforge.aventurando.sistemas.dnd5e.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.sistemas.dnd5e.models.Inventario;

public interface InventarioRepository extends CrudRepository<Inventario, Integer>{
	Optional<Inventario> findById(Integer id);
	Iterable<Inventario> findAll();
}