package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanCombos;
import mil.sinte.BusinessServices.Beans.BeanMenu;
import mil.sinte.DataService.DAO.UsuarioMenuDAO;
import mil.sinte.DataService.Service.UsuarioMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class UsuarioMenuServiceImpl implements UsuarioMenuService {

    @Autowired
    private UsuarioMenuDAO usuarioMenuDAO;

    @Override
    public List<BeanMenu> getMenuUsuario(String usuario) {
        return usuarioMenuDAO.getMenuUsuario(usuario);
    }

    @Override
    public List<BeanMenu> getModuloUsuario(String usuario) {
        return usuarioMenuDAO.getModuloUsuario(usuario);
    }

}
