package pe.edu.upeu.sysventas.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysventas.modelo.Marca;
import pe.edu.upeu.sysventas.modelo.Perfil;
import pe.edu.upeu.sysventas.repositorio.MarcaRepository;
import pe.edu.upeu.sysventas.repositorio.PerfilRepository;

import java.util.List;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;
    // Create
    public Perfil guardarEntidad(Perfil to) {
        return perfilRepository.save(to);
    }
    // Report
    public List<Perfil> listarEntidad() {
        return perfilRepository.findAll();
    }
    // Update
    public Perfil actualizarEntidad(Perfil to) {
        return perfilRepository.save(to);
    }
    // Delete
    public void eliminarRegEntidad(Long id) {
        perfilRepository.deleteById(id);
    }
    // Buscar por ID
    public Perfil buscarEntidad(Long id) {
        return perfilRepository.findById(id).orElse(null);
    }

}
