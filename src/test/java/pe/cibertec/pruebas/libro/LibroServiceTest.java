package pe.cibertec.pruebas.libro;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.cibertec.pruebas.libro.model.Libro;
import pe.cibertec.pruebas.libro.repository.LibroRepository;
import pe.cibertec.pruebas.libro.service.LibroService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LibroServiceTest {

    @Mock
    private LibroRepository repository;

    @InjectMocks
    private LibroService libroService;

    @ParameterizedTest
    @CsvSource({"1, 1", "' 7 ', 7", "'\t15\t', 15", "2147483647, 2147483647"})
    void libroExistenteDevuelveTitulo(String idIngresado, int idEsperado) {
        Libro libro = new Libro(idEsperado, "Cien años de soledad");
        when(repository.findById(idEsperado)).thenReturn(Optional.of(libro));

        String resultado = libroService.consultarLibro(idIngresado);

        assertEquals("Cien años de soledad", resultado);
        verify(repository).findById(idEsperado);
        verifyNoMoreInteractions(repository);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "0", "-5", "1.5", "1e3", "1 2", "2147483648", "-2147483649"})
    void idInvalidoNoConsultaRepositorio(String id) {
        String resultado = libroService.consultarLibro(id);

        assertEquals("Ingrese un ID válido", resultado);
        verifyNoInteractions(repository);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   ", "\t", "\n"})
    void campoVacioNoConsultaRepositorio(String id) {
        String resultado = libroService.consultarLibro(id);

        assertEquals("Debe ingresar los datos requeridos", resultado);
        verifyNoInteractions(repository);
    }

    @Test
    void libroNoEncontrado() {
        when(repository.findById(2)).thenReturn(Optional.empty());

        String resultado = libroService.consultarLibro("2");

        assertEquals("Libro no encontrado", resultado);
        verify(repository).findById(2);
        verifyNoMoreInteractions(repository);
    }
}
