package github_bethaniafreitas.Library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import github_bethaniafreitas.Library.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}