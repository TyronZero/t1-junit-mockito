package pe.edu.cibertec.pruebas.producto.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.edu.cibertec.pruebas.producto.model.Producto;
import pe.edu.cibertec.pruebas.producto.repository.ProductoRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductoServiceTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoService productoService;

    @Test
    void consultarProducto_Exito() {
        Producto producto = new Producto(1, "Laptop Lenovo");
        when(productoRepository.findById(1)).thenReturn(Optional.of(producto));

        String resultado = productoService.consultarProducto("1");

        assertEquals("Laptop Lenovo", resultado);
        verify(productoRepository, times(1)).findById(1);
    }

    @Test
    void consultarProducto_CampoVacio() {
        assertEquals("Debe ingresar los datos requeridos", productoService.consultarProducto(""));
        assertEquals("Debe ingresar los datos requeridos", productoService.consultarProducto("   "));
        assertEquals("Debe ingresar los datos requeridos", productoService.consultarProducto(null));
        verifyNoInteractions(productoRepository);
    }

    @Test
    void consultarProducto_IdInvalido() {
        assertEquals("Ingrese un ID válido", productoService.consultarProducto("0"));
        assertEquals("Ingrese un ID válido", productoService.consultarProducto("-2"));
        assertEquals("Ingrese un ID válido", productoService.consultarProducto("abc"));
        verifyNoInteractions(productoRepository);
    }

    @Test
    void consultarProducto_NoEncontrado() {
        when(productoRepository.findById(99)).thenReturn(Optional.empty());

        String resultado = productoService.consultarProducto("99");

        assertEquals("Producto no encontrado", resultado);
        verify(productoRepository, times(1)).findById(99);
    }
}