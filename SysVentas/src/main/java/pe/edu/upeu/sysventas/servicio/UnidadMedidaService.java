package pe.edu.upeu.sysventas.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysventas.dto.ComboBoxOption;
import pe.edu.upeu.sysventas.modelo.Marca;
import pe.edu.upeu.sysventas.modelo.UnidadMedida;
import pe.edu.upeu.sysventas.repositorio.UnidadMedidaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UnidadMedidaService {

    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;

    // Create
    public UnidadMedida guardarEntidad(UnidadMedida to) {
        return unidadMedidaRepository.save(to);
    }

    // Report
    public List<UnidadMedida> listarEntidad() {
        return unidadMedidaRepository.findAll();
    }

    // Update
    public UnidadMedida actualizarEntidad(UnidadMedida to) {
        return unidadMedidaRepository.save(to);
    }

    // Delete
    public void eliminarRegEntidad(Long id) {
        unidadMedidaRepository.deleteById(id);
    }

    // Buscar por ID
    public UnidadMedida buscarEntidad(Long id) {
        return unidadMedidaRepository.findById(id).orElse(null);
    }

    public List<ComboBoxOption> listarCombobox(){
        List<ComboBoxOption> listar=new ArrayList<>();
        ComboBoxOption cb;
        for(UnidadMedida cate : unidadMedidaRepository.findAll()) {
            cb=new ComboBoxOption();
            cb.setKey(String.valueOf(cate.getIdUnidad()));
            cb.setValue(cate.getNombreMedida());
            listar.add(cb);
        }
        return listar;
    }

}
