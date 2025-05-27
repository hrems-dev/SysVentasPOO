package pe.edu.upeu.sysventas.servicio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysventas.modelo.Producto;
import pe.edu.upeu.sysventas.repositorio.ProductoRepository;

import java.util.List;

@Service
public class ProductoService {
    private static final Logger logger =
            LoggerFactory.getLogger(ProductoService.class);
    @Autowired
    ProductoRepository productoRepository;
    // Create
    public Producto guardarEntidad(Producto producto) {
        return productoRepository.save(producto);
    }
    // Report
    public List<Producto> listarEntidad() {
        return productoRepository.findAll();
    }
    // Update
    public Producto actualizarEntidad(Producto producto) {
        return productoRepository.save(producto);
    }
    // Delete
    public void eliminarRegEntidad(Long idProducto) {
        productoRepository.deleteById(idProducto);
    }
    // Buscar por ID
    public Producto buscarProducto(Long idProducto) {
        return productoRepository.findById(idProducto).orElse(null);
    }

    /*public List<ModeloDataAutocomplet> listAutoCompletProducto(String
                                                                       nombre) {
        List<ModeloDataAutocomplet> listarProducto = new ArrayList<>();
        try {
            for (Producto producto :
                    productoRepository.listAutoCompletProducto(nombre + "%")) {
                ModeloDataAutocomplet data = new ModeloDataAutocomplet();
                data.setIdx(producto.getNombre());
                data.setNameDysplay(String.valueOf(producto.getIdProducto()));
                data.setOtherData(producto.getPu() + ":" +
                        producto.getStock());
                listarProducto.add(data);
            }
        } catch (Exception e) {
            logger.error("Error al realizar la busqueda", e);
        }
        return listarProducto;
    }
    public List<ModeloDataAutocomplet> listAutoCompletProducto() {
        List<ModeloDataAutocomplet> listarProducto = new ArrayList<>();
        try {
            for (Producto producto : productoRepository.findAll()) {ModeloDataAutocomplet data = new ModeloDataAutocomplet();
                data.setIdx(String.valueOf(producto.getIdProducto()));
                data.setNameDysplay(producto.getNombre());
                data.setOtherData(producto.getPu() + ":" +
                        producto.getStock());
                listarProducto.add(data);
            }
        } catch (Exception e) {
            logger.error("Error al realizar la busqueda", e);
        }
        return listarProducto;
    }*/
}