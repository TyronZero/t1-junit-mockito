package pe.cibertec.pruebas.cliente.repository;

import pe.cibertec.pruebas.cliente.model.Cliente;

import java.util.Optional;

public interface ClienteRepository {
    Optional<Cliente> findById(int id);
}
