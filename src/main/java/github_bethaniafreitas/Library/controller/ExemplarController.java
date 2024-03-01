package github_bethaniafreitas.Library.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import github_bethaniafreitas.Library.domain.Exemplar;
import github_bethaniafreitas.Library.domain.Livro;
import github_bethaniafreitas.Library.service.ExemplarService;

@RestController
@RequestMapping("/api/livros/{livroId}/exemplares")
public class ExemplarController {

	@Autowired
	ExemplarService exemplarService;

	@PostMapping
	public Exemplar aumentarQuantidade(@PathVariable Long livroId, @RequestBody Exemplar exemplar) {
	    return exemplarService.criarExemplar(livroId, exemplar);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Exemplar> obter(@PathVariable long id) {
	    Optional<Exemplar> exemplar = exemplarService.obter(id);
	    return exemplar.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}


	@DeleteMapping
	public Exemplar diminuirQuantidade(@PathVariable Long livroId, @RequestBody Exemplar exemplar) {
		return exemplarService.deletarExemplar(livroId, exemplar);
	}

}
