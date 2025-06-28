package com.dragonforge.aventurando.repositorios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dragonforge.aventurando.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	Usuario findByUsuario(String usuario);
	Optional<Usuario> findById(Integer id);
	Iterable<Usuario> findAll();
}