package pe.edu.upeu.sysventas.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysventas.modelo.Perfil;
import pe.edu.upeu.sysventas.modelo.Usuario;
import pe.edu.upeu.sysventas.repositorio.PerfilRepository;
import pe.edu.upeu.sysventas.repositorio.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    // Create
    public Usuario guardarEntidad(Usuario to) {
        return usuarioRepository.save(to);
    }
    // Report
    public List<Usuario> listarEntidad() {
        return usuarioRepository.findAll();
    }
    // Update
    public Usuario actualizarEntidad(Usuario to) {
        return usuarioRepository.save(to);
    }
    // Delete
    public void eliminarRegEntidad(Long id) {
        usuarioRepository.deleteById(id);
    }
    // Buscar por ID
    public Usuario buscarEntidad(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario loginUsuario(String user, String clave) {
        return usuarioRepository.loginUsuario(user, clave);
    }

}
