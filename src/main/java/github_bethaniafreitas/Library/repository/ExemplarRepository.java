package github_bethaniafreitas.Library.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import github_bethaniafreitas.Library.domain.Exemplar;
import github_bethaniafreitas.Library.domain.Livro;
import github_bethaniafreitas.Library.domain.Reservas;

@Repository
public interface ExemplarRepository extends JpaRepository<Exemplar, Long>{
	Optional<Exemplar> findByLivro(Livro livro);
}
