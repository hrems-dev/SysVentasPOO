package pe.edu.upeu.sysventas.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pe.edu.upeu.sysventas.modelo.CarritoVenta;
import pe.edu.upeu.sysventas.repositorio.CarritoVentaRepository;

@Service
public class VentaCarritoService {

    @Autowired
    CarritoVentaRepository repo;

    public CarritoVenta save(CarritoVenta to) {
        return repo.save(to);
    }

    public List<CarritoVenta> list() {
        return repo.findAll();
    }

    public CarritoVenta update(CarritoVenta to, Long id) {
        try {
            CarritoVenta toe = repo.findById(id).orElse(null);
            if (toe != null) {
                toe.setEstado(to.getEstado());
                return repo.save(toe);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public CarritoVenta searchById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<CarritoVenta> listaCarritoCliente(String dni) {
        return repo.listaCarritoCliente(dni);
    }

    @Transactional
    public void deleteCarAll(String dniruc) {
        this.repo.deleteByDniruc(dniruc);
    }
}
