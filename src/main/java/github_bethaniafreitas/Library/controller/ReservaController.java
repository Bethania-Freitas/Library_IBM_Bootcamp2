package github_bethaniafreitas.Library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import github_bethaniafreitas.Library.domain.Reservas;

import github_bethaniafreitas.Library.service.ReservaService;

@RestController
@RequestMapping("/api/livros/{livroId}/reservas")
public class ReservaController {

	@Autowired
	ReservaService reservaService;

	@PostMapping
	public ResponseEntity<Reservas> criarReserva(@PathVariable Long livroId, @RequestBody Reservas reserva) {
		Reservas novaReserva = reservaService.criarReserva(livroId, reserva);
		return new ResponseEntity<>(novaReserva, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Reservas>> listarReservasPorLivro(@PathVariable Long livroId) {
		List<Reservas> reservas = reservaService.listarReservasPorLivro(livroId);
		return new ResponseEntity<>(reservas, HttpStatus.OK);
	}
}
