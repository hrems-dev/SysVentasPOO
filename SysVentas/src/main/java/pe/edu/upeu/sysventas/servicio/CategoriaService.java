package pe.edu.upeu.sysventas.servicio;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysventas.dto.ComboBoxOption;
import pe.edu.upeu.sysventas.modelo.Categoria;
import pe.edu.upeu.sysventas.repositorio.CategoriaRepository;

@Service
public class CategoriaService {

    private static final Logger logger = LoggerFactory.getLogger(CategoriaService.class);

    @Autowired
    CategoriaRepository categoriaRepository;

    // Create
    public Categoria guardarEntidad(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Report
    public List<Categoria> listarEntidad() {
        return categoriaRepository.findAll();
    }

    // Update
    public Categoria update(Categoria to, Long id) {
        try {
            Categoria toe = categoriaRepository.findById(id).get();
            if (toe != null) {
                toe.setNombre(to.getNombre());
            }
            return categoriaRepository.save(toe);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public Categoria actualizarEntidad(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Delete
    public void eliminarRegEntidad(Long idCategoria) {
        categoriaRepository.deleteById(idCategoria);
    }

    // Buscar por ID
    public Categoria buscarCategoria(Long idCategoria) {
        return categoriaRepository.findById(idCategoria).orElse(null);
    }

    public List<ComboBoxOption> listarCombobox() {
        List<ComboBoxOption> listar = new ArrayList<>();
        ComboBoxOption cb;
        for (Categoria cate : categoriaRepository.findAll()) {
            cb = new ComboBoxOption();
            cb.setKey(String.valueOf(cate.getIdCategoria()));
            cb.setValue(cate.getNombre());
            listar.add(cb);
        }
        return listar;
    }
}
