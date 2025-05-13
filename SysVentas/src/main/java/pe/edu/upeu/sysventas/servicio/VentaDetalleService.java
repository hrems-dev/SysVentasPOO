package pe.edu.upeu.sysventas.servicio;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysventas.modelo.VentaDetalle;
import pe.edu.upeu.sysventas.repositorio.VentaDetalleRepository;

@Service
public class VentaDetalleService {

    private static final Logger logger = LoggerFactory.getLogger(VentaDetalleService.class);

    @Autowired
    VentaDetalleRepository ventaDetalleRepository;

    // Create
    public VentaDetalle guardarEntidad(VentaDetalle ventaDetalle) {
        return ventaDetalleRepository.save(ventaDetalle);
    }

    // Report
    public List<VentaDetalle> listarEntidad() {
        return ventaDetalleRepository.findAll();
    }

    // Update
    public VentaDetalle actualizarEntidad(VentaDetalle ventaDetalle) {
        return ventaDetalleRepository.save(ventaDetalle);
    }

    // Delete
    public void eliminarRegEntidad(Long idVentaDetalle) {
        ventaDetalleRepository.deleteById(idVentaDetalle);
    }

    // Buscar por ID
    public VentaDetalle buscarVentaDetalle(Long idVentaDetalle) {
        return ventaDetalleRepository.findById(idVentaDetalle).orElse(null);
    }
}