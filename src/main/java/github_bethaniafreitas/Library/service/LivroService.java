package github_bethaniafreitas.Library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Exceptions.LivroNotFoundException;
import github_bethaniafreitas.Library.domain.Exemplar;
import github_bethaniafreitas.Library.domain.Livro;
import github_bethaniafreitas.Library.repository.ExemplarRepository;
import github_bethaniafreitas.Library.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	LivroRepository livroRepository;

	@Autowired
	ExemplarRepository exemplarRepository;

	public Livro criarLivro(Livro livro) {
		Livro livroCriado = livroRepository.saveAndFlush(livro);
		Exemplar exemplar = new Exemplar();
		exemplar.setQuantidade(1);
		exemplar.setLivro(livroCriado);
		exemplarRepository.saveAndFlush(exemplar);
		return livroCriado;
	}

	public List<Livro> listar() {
		return livroRepository.findAll();
	}

	public Optional<Livro> obter(long id) {
		return livroRepository.findById(id);
	}

	public Livro alterar(Long id, Livro novoLivro) {
		if (livroRepository.existsById(id)) {
			novoLivro.setId(id);
			return livroRepository.save(novoLivro);
		} else {
			throw new LivroNotFoundException("Livro não encontrado com o ID: " + id);
		}
	}

	public void excluir(long id) {
		Optional<Livro> livroOptional = livroRepository.findById(id);
		livroOptional.ifPresent(livro -> {
			livro.setAtivo(false);
			livroRepository.save(livro);
		});
	}
}
