package com.dragonforge.aventurando.central.repositorios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.central.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	Usuario findByUsuario(String usuario);
	
	Iterable<Usuario> findByAcesso(String acesso);
	
	Optional<Usuario> findById(Integer id);

	Iterable<Usuario> findAll();
	
	Iterable<Usuario> findByIdUsuarioAndAcesso(Integer id, String acesso);
}