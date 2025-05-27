package pe.edu.upeu.sysventas.servicio;

import pe.edu.upeu.sysventas.dto.MenuMenuItenTO;

import java.util.List;
import java.util.Properties;

public interface MenuMenuItenDaoI {
    public List<MenuMenuItenTO> listaAccesos(String perfil, Properties idioma);
}
