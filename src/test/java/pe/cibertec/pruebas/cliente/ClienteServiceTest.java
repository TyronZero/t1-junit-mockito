package pe.cibertec.pruebas.cliente;

import org.junit.jupiter.api.Test;
import pe.cibertec.pruebas.cliente.model.Cliente;
import pe.cibertec.pruebas.cliente.repository.ClienteRepository;
import pe.cibertec.pruebas.cliente.service.ClienteService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ClienteServiceTest {

    @Test
    void clienteExistente() {
        ClienteRepository repository = mock(ClienteRepository.class);
        ClienteService clienteService = new ClienteService(repository);

        Cliente cliente = new Cliente(1, "Carlos", "Ramírez", "cramirez@gmail.com", true);
        when(repository.findById(1)).thenReturn(Optional.of(cliente));

        String result = clienteService.consultarCliente("1");

        assertEquals("Carlos Ramírez - cramirez@gmail.com", result);
        verify(repository).findById(1);
    }

    @Test
    void idNoNumerico() {
        ClienteRepository repository = mock(ClienteRepository.class);
        ClienteService clienteService = new ClienteService(repository);

        String result = clienteService.consultarCliente("abc");

        assertEquals("Ingrese un ID correcto", result);
        verifyNoInteractions(repository);
    }

    @Test
    void idCeroONegativo() {
        ClienteRepository repository = mock(ClienteRepository.class);
        ClienteService clienteService = new ClienteService(repository);

        assertEquals("Ingrese un ID correcto", clienteService.consultarCliente("0"));
        assertEquals("Ingrese un ID correcto", clienteService.consultarCliente("-5"));
        verifyNoInteractions(repository);
    }

    @Test
    void campoVacio() {
        ClienteRepository repository = mock(ClienteRepository.class);
        ClienteService clienteService = new ClienteService(repository);

        assertEquals("Debe ingresar los datos requeridos", clienteService.consultarCliente(""));
        assertEquals("Debe ingresar los datos requeridos", clienteService.consultarCliente(null));
        verifyNoInteractions(repository);
    }

    @Test
    void clienteNoRegistrado() {
        ClienteRepository repository = mock(ClienteRepository.class);
        ClienteService clienteService = new ClienteService(repository);

        when(repository.findById(2)).thenReturn(Optional.empty());

        String result = clienteService.consultarCliente("2");

        assertEquals("Cliente no registrado", result);
        verify(repository).findById(2);
    }

    @Test
    void clienteInactivo() {
        ClienteRepository repository = mock(ClienteRepository.class);
        ClienteService clienteService = new ClienteService(repository);

        Cliente cliente = new Cliente(3, "Lucía", "Torres", "ltorres@gmail.com", false);
        when(repository.findById(3)).thenReturn(Optional.of(cliente));

        String result = clienteService.consultarCliente("3");

        assertEquals("Cliente inactivo", result);
        verify(repository).findById(3);
    }
}
