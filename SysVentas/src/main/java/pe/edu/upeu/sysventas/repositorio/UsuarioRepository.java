package pe.edu.upeu.sysventas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upeu.sysventas.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
