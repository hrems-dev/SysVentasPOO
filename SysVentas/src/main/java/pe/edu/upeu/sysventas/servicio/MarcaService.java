package pe.edu.upeu.sysventas.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysventas.dto.ComboBoxOption;
import pe.edu.upeu.sysventas.modelo.Categoria;
import pe.edu.upeu.sysventas.modelo.Marca;
import pe.edu.upeu.sysventas.modelo.Producto;
import pe.edu.upeu.sysventas.repositorio.MarcaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarcaService {
    @Autowired
    private MarcaRepository marcaRepository;
    // Create
    public Marca guardarEntidad(Marca to) {
        return marcaRepository.save(to);
    }
    // Report
    public List<Marca> listarEntidad() {
        return marcaRepository.findAll();
    }
    // Update
    public Marca actualizarEntidad(Marca to) {
        return marcaRepository.save(to);
    }
    // Delete
    public void eliminarRegEntidad(Long id) {
        marcaRepository.deleteById(id);
    }
    // Buscar por ID
    public Marca buscarEntidad(Long id) {
        return marcaRepository.findById(id).orElse(null);
    }

    public List<ComboBoxOption> listarCombobox(){
        List<ComboBoxOption> listar=new ArrayList<>();
        ComboBoxOption cb;
        for(Marca cate : marcaRepository.findAll()) {
            cb=new ComboBoxOption();
            cb.setKey(String.valueOf(cate.getIdMarca()));
            cb.setValue(cate.getNombre());
            listar.add(cb);
        }
        return listar;
    }

}
