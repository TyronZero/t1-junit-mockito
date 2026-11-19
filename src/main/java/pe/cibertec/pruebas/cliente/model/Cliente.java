package pe.cibertec.pruebas.cliente.model;

public class Cliente {
    private Integer id;
    private String nombre;
    private String apellido;
    private String correo;
    private Boolean activo;

    public Cliente(Integer id, String nombre, String apellido, String correo, Boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.activo = activo;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public Boolean getActivo() {
        return activo;
    }
}
