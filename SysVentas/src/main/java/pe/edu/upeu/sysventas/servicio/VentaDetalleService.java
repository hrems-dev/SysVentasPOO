package pe.edu.upeu.sysventas.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysventas.modelo.VentaDetalle;
import pe.edu.upeu.sysventas.repositorio.VentaDetalleRepository;

import java.util.List;

@Service
public class VentaDetalleService{

    @Autowired
    private VentaDetalleRepository ventaDetalleRepository;

    // Create
    public VentaDetalle guardarEntidad(VentaDetalle to) {
        return ventaDetalleRepository.save(to);
    }

    // Report
    public List<VentaDetalle> listarEntidad() {
        return ventaDetalleRepository.findAll();
    }

    // Update
    public VentaDetalle actualizarEntidad(VentaDetalle to) {
        return ventaDetalleRepository.save(to);
    }

    // Delete
    public void eliminarRegEntidad(Long id) {
        ventaDetalleRepository.deleteById(id);
    }

    // Buscar por ID
    public VentaDetalle buscarEntidad(Long id) {
        return ventaDetalleRepository.findById(id).orElse(null);
    }
}
