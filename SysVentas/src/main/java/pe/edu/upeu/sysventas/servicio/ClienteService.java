package pe.edu.upeu.sysventas.servicio;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysventas.modelo.Cliente;
import pe.edu.upeu.sysventas.repositorio.ClienteRepository;

@Service
public class ClienteService {

    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    @Autowired
    ClienteRepository clienteRepository;

    // Create
    public Cliente guardarEntidad(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Report
    public List<Cliente> listarEntidad() {
        return clienteRepository.findAll();
    }

    // Update
    public Cliente actualizarEntidad(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Delete
    public void eliminarRegEntidad(Long idCliente) {
        clienteRepository.deleteById(idCliente);
    }

    // Buscar por ID
    public Cliente buscarCliente(Long idCliente) {
        return clienteRepository.findById(idCliente).orElse(null);
    }
}