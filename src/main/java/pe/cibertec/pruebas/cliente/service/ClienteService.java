package pe.cibertec.pruebas.cliente.service;

import pe.cibertec.pruebas.cliente.model.Cliente;
import pe.cibertec.pruebas.cliente.repository.ClienteRepository;

public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public String consultarCliente(String id) {
        if (id == null || id.isBlank()) {
            return "Debe ingresar los datos requeridos";
        }
        int idNumerico;
        try {
            idNumerico = Integer.parseInt(id.trim());
        } catch (NumberFormatException e) {
            return "Ingrese un ID correcto";
        }
        if (idNumerico <= 0) {
            return "Ingrese un ID correcto";
        }
        Cliente cliente = clienteRepository.findById(idNumerico).orElse(null);
        if (cliente == null) {
            return "Cliente no registrado";
        }
        if (!Boolean.TRUE.equals(cliente.getActivo())) {
            return "Cliente inactivo";
        }
        return cliente.getNombre() + " " + cliente.getApellido() + " - " + cliente.getCorreo();
    }
}
