package pe.edu.upeu.sysventas.servicio;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysventas.modelo.Proveedor;
import pe.edu.upeu.sysventas.repositorio.ProveedorRepository;

@Service
public class ProveedorService {

    private static final Logger logger = LoggerFactory.getLogger(ProveedorService.class);

    @Autowired
    ProveedorRepository proveedorRepository;

    // Create
    public Proveedor guardarEntidad(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    // Report
    public List<Proveedor> listarEntidad() {
        return proveedorRepository.findAll();
    }

    // Update
    public Proveedor actualizarEntidad(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    // Delete
    public void eliminarRegEntidad(Long idProveedor) {
        proveedorRepository.deleteById(idProveedor);
    }

    // Buscar por ID
    public Proveedor buscarProveedor(Long idProveedor) {
        return proveedorRepository.findById(idProveedor).orElse(null);
    }
}