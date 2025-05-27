package pe.edu.upeu.sysventas.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.upeu.sysventas.modelo.Perfil;
import pe.edu.upeu.sysventas.repositorio.PerfilRepository;

public class PerfilService {

    @Autowired
    PerfilRepository repo;

    public Perfil save(Perfil to) {
        return repo.save(to);
    }

    public List<Perfil> list() {
        return repo.findAll();
    }

    public Perfil update(Perfil to, Long id) {
        try {
            Perfil toe = repo.findById(id).orElse(null);
            if (toe != null) {
                toe.setNombre(to.getNombre());
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

    public Perfil searchById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
