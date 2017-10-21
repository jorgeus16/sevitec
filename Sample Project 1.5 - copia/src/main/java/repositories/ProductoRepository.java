package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

	@Query("select c.productos from Categoria c where c.id = ?1")
	Collection<Producto> findProductByCategory();


}
