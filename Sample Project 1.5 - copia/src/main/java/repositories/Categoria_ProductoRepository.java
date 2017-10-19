package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Categoria_Producto;

@Repository
public interface Categoria_ProductoRepository extends JpaRepository<Categoria_Producto, Integer> {



}
