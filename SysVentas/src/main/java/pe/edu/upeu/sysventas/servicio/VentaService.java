package pe.edu.upeu.sysventas.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysventas.modelo.Venta;
import pe.edu.upeu.sysventas.repositorio.VentaRepository;

import java.util.List;

@Service
public class VentaService{

    @Autowired
    private VentaRepository ventaRepository;

    // Create
    public Venta guardarEntidad(Venta to) {
        return ventaRepository.save(to);
    }

    // Report
    public List<Venta> listarEntidad() {
        return ventaRepository.findAll();
    }

    // Update
    public Venta actualizarEntidad(Venta to) {
        return ventaRepository.save(to);
    }

    // Delete
    public void eliminarRegEntidad(Long id) {
        ventaRepository.deleteById(id);
    }

    // Buscar por ID
    public Venta buscarEntidad(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }
}
