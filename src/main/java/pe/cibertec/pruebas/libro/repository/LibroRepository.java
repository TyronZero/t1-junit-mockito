package pe.cibertec.pruebas.libro.repository;

import pe.cibertec.pruebas.libro.model.Libro;

import java.util.Optional;

public interface LibroRepository {
    Optional<Libro> findById(int id);
}
