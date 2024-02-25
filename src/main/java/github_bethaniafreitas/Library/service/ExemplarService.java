package github_bethaniafreitas.Library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Exceptions.LivroNotFoundException;
import Exceptions.LivroSemExemplaresException;
import github_bethaniafreitas.Library.domain.Exemplar;
import github_bethaniafreitas.Library.domain.Livro;
import github_bethaniafreitas.Library.repository.ExemplarRepository;
import github_bethaniafreitas.Library.repository.LivroRepository;
import jakarta.transaction.Transactional;

@Service
public class ExemplarService {

	@Autowired
	ExemplarRepository exemplarRepository;

	@Autowired
	LivroRepository livroRepository;

	@Transactional
	public Exemplar criarExemplar(Long livroId, Exemplar input) {
		Livro livro = livroRepository.findById(livroId)
				.orElseThrow(() -> new LivroNotFoundException("Livro não encontrado com ID: " + livroId));

		Exemplar exemplar = obterExemplarDoLivro(livro);
		exemplar.setQuantidade(exemplar.getQuantidade() + input.getQuantidade());
		return exemplarRepository.save(exemplar);
	}

	@Transactional
	public Exemplar deletarExemplar(Long livroId, Exemplar input) {
		Livro livro = livroRepository.findById(livroId)
				.orElseThrow(() -> new LivroNotFoundException("Livro não encontrado com ID: " + livroId));

		Exemplar exemplar = obterExemplarDoLivro(livro);
		var quantidadeAnterior = exemplar.getQuantidade();
		var novaQuantidade = quantidadeAnterior - input.getQuantidade();
		if (novaQuantidade < 0) {
			throw new LivroSemExemplaresException(
					"quantidade de copias disponiveis que podem ser deletadas: " + quantidadeAnterior);
		}
		exemplar.setQuantidade(novaQuantidade);
		return exemplarRepository.save(exemplar);
	}

	private Exemplar obterExemplarDoLivro(Livro livro) {
		return livro.getExemplares().stream().findFirst()
				.orElseThrow(() -> new IllegalStateException("Livro não possui exemplar associado."));
	}

}
