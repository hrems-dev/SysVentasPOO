package pe.edu.upeu.sysventas.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysventas.dto.ComboBoxOption;
import pe.edu.upeu.sysventas.modelo.Categoria;
import pe.edu.upeu.sysventas.modelo.Marca;
import pe.edu.upeu.sysventas.repositorio.CategoriaRepository;
import pe.edu.upeu.sysventas.repositorio.MarcaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    // Create
    public Categoria guardarEntidad(Categoria to) {
        return categoriaRepository.save(to);
    }
    // Report
    public List<Categoria> listarEntidad() {
        return categoriaRepository.findAll();
    }
    // Update
    public Categoria actualizarEntidad(Categoria to) {
        return categoriaRepository.save(to);
    }
    // Delete
    public void eliminarRegEntidad(Long id) {
        categoriaRepository.deleteById(id);
    }
    // Buscar por ID
    public Categoria buscarEntidad(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public List<ComboBoxOption> listarCombobox(){
        List<ComboBoxOption> listar=new ArrayList<>();
        ComboBoxOption cb;
        for(Categoria cate : categoriaRepository.findAll()) {
            cb=new ComboBoxOption();
            cb.setKey(String.valueOf(cate.getIdCategoria()));
            cb.setValue(cate.getNombre());
            listar.add(cb);
        }
        return listar;
    }


}
