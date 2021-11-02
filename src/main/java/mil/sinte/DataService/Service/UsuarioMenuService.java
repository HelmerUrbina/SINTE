package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanMenu;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface UsuarioMenuService {

    public List<BeanMenu> getMenuUsuario(String usuario);

    public List<BeanMenu> getModuloUsuario(String usuario);

}
