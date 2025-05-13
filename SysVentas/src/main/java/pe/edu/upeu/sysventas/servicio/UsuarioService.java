package pe.edu.upeu.sysventas.servicio;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysventas.modelo.Usuario;
import pe.edu.upeu.sysventas.repositorio.UsuarioRepository;

@Service
public class UsuarioService {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    UsuarioRepository usuarioRepository;

    // Create
    public Usuario guardarEntidad(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Report
    public List<Usuario> listarEntidad() {
        return usuarioRepository.findAll();
    }

    // Update
    public Usuario actualizarEntidad(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Delete
    public void eliminarRegEntidad(Long idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }

    // Buscar por ID
    public Usuario buscarUsuario(Long idUsuario) {
        return usuarioRepository.findById(idUsuario).orElse(null);
    }
}