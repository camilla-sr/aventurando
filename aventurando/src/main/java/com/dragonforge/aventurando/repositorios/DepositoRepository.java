package com.dragonforge.aventurando.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.models.Deposito;

public interface DepositoRepository extends CrudRepository<Deposito, Integer>{
	Optional<Deposito> findById(Integer id);
	Iterable<Deposito> findAll();
}
