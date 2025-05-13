package pe.edu.upeu.sysventas.servicio;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysventas.modelo.Venta;
import pe.edu.upeu.sysventas.repositorio.VentaRepository;

@Service
public class VentaService {

    private static final Logger logger = LoggerFactory.getLogger(VentaService.class);

    @Autowired
    VentaRepository ventaRepository;

    // Create
    public Venta guardarEntidad(Venta venta) {
        return ventaRepository.save(venta);
    }

    // Report
    public List<Venta> listarEntidad() {
        return ventaRepository.findAll();
    }

    // Update
    public Venta actualizarEntidad(Venta venta) {
        return ventaRepository.save(venta);
    }

    // Delete
    public void eliminarRegEntidad(Long idVenta) {
        ventaRepository.deleteById(idVenta);
    }

    // Buscar por ID
    public Venta buscarVenta(Long idVenta) {
        return ventaRepository.findById(idVenta).orElse(null);
    }
}