package github_bethaniafreitas.Library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import github_bethaniafreitas.Library.domain.Exemplar;
import github_bethaniafreitas.Library.service.ExemplarService;

@RestController
@RequestMapping("/api/livros/{livroId}/exemplares")
public class ExemplarController {

	@Autowired
	ExemplarService service;

	@PostMapping
	public Exemplar aumentarQuantidade(@PathVariable Long livroId, @RequestBody Exemplar exemplar) {
		return service.criarExemplar(livroId, exemplar);
	}

	@DeleteMapping
	public Exemplar diminuirQuantidade(@PathVariable Long livroId, @RequestBody Exemplar exemplar) {
		return service.deletarExemplar(livroId, exemplar);
	}

}
