package pe.edu.cibertec.ejercicio1.service;

import pe.edu.cibertec.ejercicio1.model.Producto;
import pe.edu.cibertec.ejercicio1.repository.ProductoRepository;

import java.util.Optional;

public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    public String consultarProducto(String idTexto){
        if (idTexto == null || idTexto.trim().isEmpty()){
            return "Debe ingresar los datos requeridos";
        }

        int id;
        try {
            id = Integer.parseInt(idTexto.trim());
        } catch (NumberFormatException e){
            return "Ingrese un ID válido";
        }

        if (id <= 0){
            return "Ingrese un ID válido";
        }

        Optional<Producto> productoOpt = productoRepository.findById(id);

        if (productoOpt.isEmpty()){
            return "Producto no encontrado";
        }
        return productoOpt.get().getNombre();
    }
}
