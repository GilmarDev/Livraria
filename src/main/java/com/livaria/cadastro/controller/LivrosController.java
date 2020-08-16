package com.livaria.cadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.livaria.cadastro.model.Livros;
import com.livaria.cadastro.respository.LivrosRepository;

@RestController
@RequestMapping("/api")
public class LivrosController {
	
	@Autowired
	LivrosRepository livrosRepository;
	
	
	@GetMapping("/buscar")
	public List<Livros> listar(){
		return livrosRepository.findAll();
	}
	
	@PostMapping("/adicionar")
	@ResponseStatus(HttpStatus.CREATED)
	public Livros adicionar(@RequestBody Livros livros ) {
		return livrosRepository.save(livros);
	}
	
	@PutMapping("/atualizar/{livrosId}")
	public ResponseEntity<Livros> atualizar(@PathVariable long livrosId,
			@RequestBody Livros livros){
		if(!livrosRepository.existsById(livrosId)) {
			return ResponseEntity.notFound().build();
		}
		livros.setCodigo(livrosId);
		livros = livrosRepository.save(livros);
		return ResponseEntity.ok(livros);
	}
	
	@DeleteMapping("/removerLivros/{livrosId}")
	public ResponseEntity<Void> removerLivros(@PathVariable long livrosId){
		if(!livrosRepository.existsById(livrosId)) {
			return ResponseEntity.notFound().build();
		}
		
		livrosRepository.deleteById(livrosId);
		return ResponseEntity.noContent().build();
	}
}

