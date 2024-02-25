package github_bethaniafreitas.Library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import github_bethaniafreitas.Library.domain.Exemplar;

@Repository
public interface ExemplarRepository extends JpaRepository<Exemplar, Long>{

}
