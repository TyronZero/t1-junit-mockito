package pe.edu.cibertec.ejercicio1.repository;

import pe.edu.cibertec.ejercicio1.model.Producto;

import java.util.Optional;

public interface ProductoRepository {
    Optional<Producto> findById(Integer id);
}
