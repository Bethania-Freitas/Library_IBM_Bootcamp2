package github_bethaniafreitas.Library.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import github_bethaniafreitas.Library.domain.Livro;
import github_bethaniafreitas.Library.service.LivroService;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

	@Autowired
	LivroService livroService;

	@PostMapping
	public ResponseEntity<Livro> cadastrarLivro(@RequestBody Livro livro) {
		Livro livroCadastrado = livroService.criarLivro(livro);
		return new ResponseEntity<>(livroCadastrado, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Livro>> listar() {
		List<Livro> livros = livroService.listar();
		return new ResponseEntity<>(livros, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Livro> obter(@PathVariable long id) {
		Optional<Livro> livro = livroService.obter(id);
		return livro.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Livro> atualizar(@RequestBody Livro novoLivro, @PathVariable long id) {
		if (!livroService.obter(id).isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		novoLivro.setId(id);
		Livro livroAtualizado = livroService.alterar(id, novoLivro);
		return new ResponseEntity<>(livroAtualizado, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable long id) {
		var livroExistente = livroService.obter(id);
		if (livroExistente != null) {
			livroService.excluir(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
