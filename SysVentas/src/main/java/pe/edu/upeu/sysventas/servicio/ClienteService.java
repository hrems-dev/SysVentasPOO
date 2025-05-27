package pe.edu.upeu.sysventas.servicio;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysventas.dto.ModeloDataAutocomplet;
import pe.edu.upeu.sysventas.modelo.Cliente;
import pe.edu.upeu.sysventas.repositorio.ClienteRepository;

@Service
public class ClienteService {

    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    @Autowired
    ClienteRepository repo;
   // Logger logger = LoggerFactory.getLogger(ClienteService.class);

    //Logger logger= LoggerFactory.getLogger(ClienteService.class); 
    // Create
    public Cliente guardarEntidad(Cliente cliente) {
        return repo.save(cliente);
    }

    // Report
    public List<Cliente> listarEntidad() {
        return repo.findAll();
    }

    // Update
    public Cliente actualizarEntidad(Cliente cliente, String dniruc) {
        return repo.findAll(cliente);
    }

    public Cliente update(Cliente to, String dniruc) {
        try {
            Cliente toe = repo.findById(dniruc).orElse(null);
            if (toe != null) {
                toe.setNombres(to.getNombres());
                return repo.save(toe);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    // Delete
    public void eliminarRegEntidad(Long idCliente) {
        repo.deleteById(idCliente);
    }

    // Buscar por ID
    public Cliente buscarCliente(Long idCliente) {
        return repo.findById(idCliente).orElse(null);
    }

    public List<ModeloDataAutocomplet> listAutoCompletCliente() {
        List<ModeloDataAutocomplet> listarclientes = new ArrayList<>();
        try {
            for (Cliente cliente : repo.findAll()) {
                ModeloDataAutocomplet data = new ModeloDataAutocomplet();
                data.setIdx(cliente.getDniruc());
                data.setNameDysplay(cliente.getNombres());
                data.setOtherData(cliente.getTipoDocumento());
                listarclientes.add(data);
            }
        } catch (Exception e) {
            logger.error("Error durante la operación", e);
        }
        return listarclientes;
    }
}
