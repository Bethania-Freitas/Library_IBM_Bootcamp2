package github_bethaniafreitas.Library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Exceptions.LivroNotFoundException;
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

		Reservas reserva = new Reservas();
		reserva.setLivro(livro);
		reserva.setUsuario(input.getUsuario());
		reserva.setDataInicio(input.getDataInicio());
		reserva.setDataFim(input.getDataFim());

		return reservaRepository.save(reserva);
	}

	public List<Reservas> listarReservasPorLivro(Long livroId) {
		Livro livroReserva = livroRepository.findById(livroId)
				.orElseThrow(() -> new LivroNotFoundException("Livro não encontrado com ID: " + livroId));
		return reservaRepository.findByLivro(livroReserva);
	}

}
