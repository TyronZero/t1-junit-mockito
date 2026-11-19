package pe.cibertec.pruebas.libro.model;

public class Libro {
    private Integer id;
    private String titulo;

    public Libro(Integer id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
