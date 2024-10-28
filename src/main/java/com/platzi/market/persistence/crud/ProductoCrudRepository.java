package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    List<Producto> getProductoByCategoria(int idCategoria); // Ejemplo de query normal

    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria); // Ejemplo de query con queryMethod

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
