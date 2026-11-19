package pe.edu.cibertec.pruebas.producto.repository;

import pe.edu.cibertec.pruebas.producto.model.Producto;

import java.util.Optional;

public interface ProductoRepository {
    Optional<Producto> findById(Integer id);
}