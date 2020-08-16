package com.livaria.cadastro.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.livaria.cadastro.model.Livros;

@Repository
public interface LivrosRepository extends JpaRepository<Livros, Long> {

	
}
