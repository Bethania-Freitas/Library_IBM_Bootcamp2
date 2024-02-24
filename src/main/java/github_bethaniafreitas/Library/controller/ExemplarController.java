package github_bethaniafreitas.Library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Exceptions.LivroNotFoundException;
import Exceptions.LivroSemExemplaresException;
import github_bethaniafreitas.Library.domain.Exemplar;
import github_bethaniafreitas.Library.service.ExemplarService;

@RestController
@RequestMapping("/api/livros/{livroId}/exemplares")
public class ExemplarController {

	@Autowired
	ExemplarService service;

	@PostMapping
    public Exemplar aumentarQuantidade(@PathVariable Long livroId, @RequestParam int quantidade) {
        return service.criarExemplar(livroId, quantidade);
    }

	@DeleteMapping
    public Exemplar diminuirQuantidade(@PathVariable Long livroId, @RequestParam int quantidade, @RequestBody Exemplar exemplar) {
        return service.deletarExemplar(livroId, quantidade, exemplar);
    }

}
