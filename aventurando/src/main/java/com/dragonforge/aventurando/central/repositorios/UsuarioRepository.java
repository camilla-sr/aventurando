package com.dragonforge.aventurando.central.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.central.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	Usuario findByUsuario(String usuario);
	
	Optional<Usuario> findById(Integer id);
	
	@Query("select * from usuario where acesso = 'jogador'")
	Iterable<Usuario> findAllJogador();
	
	@Query("select * from usuario where acesso = 'mestre'")
	Iterable<Usuario> findAllMestre();
	
	Iterable<Usuario> findAll();
}