package pe.cibertec.pruebas.libro.service;

import pe.cibertec.pruebas.libro.model.Libro;
import pe.cibertec.pruebas.libro.repository.LibroRepository;

public class LibroService {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public String consultarLibro(String id) {
        if (id == null || id.isBlank()) {
            return "Debe ingresar los datos requeridos";
        }

        int idNumerico;
        try {
            idNumerico = Integer.parseInt(id.trim());
        } catch (NumberFormatException e) {
            return "Ingrese un ID válido";
        }

        if (idNumerico <= 0) {
            return "Ingrese un ID válido";
        }

        return libroRepository.findById(idNumerico)
                .map(Libro::getTitulo)
                .orElse("Libro no encontrado");
    }
}
