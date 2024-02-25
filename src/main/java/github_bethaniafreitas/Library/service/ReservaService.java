package github_bethaniafreitas.Library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Exceptions.ExemplarNotFoundException;
import Exceptions.LivroNotFoundException;
import Exceptions.LivroSemExemplaresException;
import github_bethaniafreitas.Library.domain.Exemplar;
import github_bethaniafreitas.Library.domain.Livro;
import github_bethaniafreitas.Library.domain.Reservas;
import github_bethaniafreitas.Library.repository.ExemplarRepository;
import github_bethaniafreitas.Library.repository.LivroRepository;
import github_bethaniafreitas.Library.repository.ReservaRepository;
import jakarta.transaction.Transactional;

@Service
public class ReservaService {
	

	@Autowired
	ReservaRepository reservaRepository;

	@Autowired
	LivroRepository livroRepository;

	@Autowired
	ExemplarRepository exemplarRepository;
	

	@Transactional
	public Reservas criarReserva(Long livroId, Reservas input) {
	    Livro livro = livroRepository.findById(livroId)
	            .orElseThrow(() -> new LivroNotFoundException("Livro não encontrado com ID: " + livroId));

	    if (!livro.isAtivo()) {
	        throw new LivroSemExemplaresException("Não há exemplares disponíveis para reserva do livro com ID: " + livroId);
	    }

	    Exemplar exemplar = obterExemplarDoLivro(livro);
	    
	    Reservas reserva = new Reservas();
	    reserva.setLivro(livro);
	    reserva.setUsuario(input.getUsuario());
	    reserva.setDataInicio(input.getDataInicio());
	    reserva.setDataFim(input.getDataFim());
	    
	    exemplar.setQuantidade(exemplar.getQuantidade() - 1);
	    
	    var exemplaresDisponiveis = exemplar.getQuantidade();
	    if (exemplaresDisponiveis == 0) {
	        livro.setAtivo(false);
	    }

	    exemplarRepository.save(exemplar); 
	    livroRepository.save(livro); 
	    return reservaRepository.save(reserva);
	}


	public List<Reservas> listarReservasPorLivro(Long livroId) {
		Livro livroReserva = livroRepository.findById(livroId)
				.orElseThrow(() -> new LivroNotFoundException("Livro não encontrado com ID: " + livroId));
		return reservaRepository.findByLivro(livroReserva);
	}
	
	public Exemplar obterExemplarDoLivro(Livro livro) {
	    return exemplarRepository.findByLivro(livro)
	            .orElseThrow(() -> new ExemplarNotFoundException("Exemplar não encontrado para o livro com ID: " + livro.getId()));
	}

}
