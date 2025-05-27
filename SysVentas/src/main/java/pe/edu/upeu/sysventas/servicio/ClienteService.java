package pe.edu.upeu.sysventas.servicio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysventas.dto.ModeloDataAutocomplet;
import pe.edu.upeu.sysventas.modelo.Categoria;
import pe.edu.upeu.sysventas.modelo.Cliente;
import pe.edu.upeu.sysventas.repositorio.CategoriaRepository;
import pe.edu.upeu.sysventas.repositorio.ClienteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository ;

    Logger logger= LoggerFactory.getLogger(ClienteService.class);

    // Create
    public Cliente guardarEntidad(Cliente to) {
        return clienteRepository.save(to);
    }
    // Report
    public List<Cliente> listarEntidad() {
        return clienteRepository.findAll();
    }
    // Update
    public Cliente actualizarEntidad(Cliente to) {
        return clienteRepository.save(to);
    }
    // Delete
    public void eliminarRegEntidad(Long id) {
        clienteRepository.deleteById(id);
    }
    // Buscar por ID
    public Cliente buscarEntidad(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public List<ModeloDataAutocomplet> listAutoCompletCliente() {
        List<ModeloDataAutocomplet> listarclientes = new ArrayList<>();
        try {
            for (Cliente cliente : clienteRepository.findAll()) {
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
