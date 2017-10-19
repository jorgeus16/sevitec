package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

	@Query("select c from Categoria c where c.parent is null")
	Collection<Categoria> findCategoriesWithChildren();

	@Query("select c from Categoria c where c.id = ?1")
	Categoria findOne(int id);
}
