package pe.edu.upeu.sysventas.servicio;

import java.util.List;
import java.util.Properties;

import pe.edu.upeu.sysventas.dto.MenuMenuItenTO;

public interface MenuMenuItenDaoI {
     public List<MenuMenuItenTO> listaAccesos(String perfil, Properties 
idioma);
}
