package pe.edu.upeu.sysventas.servicio;

import java.io.File;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.criteria.Path;
import pe.edu.upeu.sysventas.modelo.Venta;
import pe.edu.upeu.sysventas.repositorio.VentaRepository;

@Service
public class VentaService {

    private static final Logger logger = LoggerFactory.getLogger(VentaService.class);

    @Autowired
    VentaRepository repo;
    @Autowired
    DataSource dataSource;

    public Venta save(Venta to) {
        return repo.save(to);
    }

    public List<Venta> list() {
        return repo.findAll();
    }

    public Venta update(Venta to, Long id) {
        try {
            Venta toe = repo.findById(id).orElse(null);
            if (toe != null) {
                toe.setSerie(to.getSerie());
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

    public Venta searchById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public File getFile(String filex) {
        File newFolder = new File("jasper");
        String ruta = newFolder.getAbsolutePath();
        //CAMINO = Paths.get(ruta+"/"+"reporte1.jrxml"); 
        Path CAMINO = (Path) Paths.get(ruta + "/" + filex);
        System.out.println("Llegasss Ruta 2:" + CAMINO.toAbsolutePath().toFile());
        return CAMINO.toFile();
    }

    public JasperPrint runReport(Long idv) throws JRException, SQLException {
        // Verificar si la venta existe 
        if (!repo.existsById(idv)) {
            throw new IllegalArgumentException("La venta con id " + idv + " no existe");
        }
        HashMap<String, Object> param = new HashMap<>();
        // Obtener ruta de la imagen 
        String imgen = getFile("logoupeu.png").getAbsolutePath();
        String urljasper = getFile("detallev.jasper").getAbsolutePath();
        // Agregar parámetros 
        param.put("idventa", idv);
        param.put("imagenurl", imgen);
        param.put("urljasper", urljasper);
        // Cargar el diseño del informe 
        JasperDesign jdesign = JRXmlLoader.load(getFile("comprobante.jrxml"));
        JasperReport jreport = JasperCompileManager.compileReport(jdesign);
        // Llenar el informe 
        return JasperFillManager.fillReport(jreport, param,
                dataSource.getConnection());
    }
}
