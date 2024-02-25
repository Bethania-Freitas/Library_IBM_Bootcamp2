package github_bethaniafreitas.Library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import github_bethaniafreitas.Library.domain.Livro;
import github_bethaniafreitas.Library.domain.Reservas;

@Repository
public interface ReservaRepository extends JpaRepository<Reservas, Long> {
	List<Reservas> findByLivro(Livro livro);
}
