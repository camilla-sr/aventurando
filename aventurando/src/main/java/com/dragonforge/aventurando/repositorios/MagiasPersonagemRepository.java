package com.dragonforge.aventurando.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.dragonforge.aventurando.models.MagiasPersonagem;

public interface MagiasPersonagemRepository extends CrudRepository<MagiasPersonagem, Integer>{
	Optional<MagiasPersonagem> findById(Integer id);
	Iterable<MagiasPersonagem> findAll();
}
