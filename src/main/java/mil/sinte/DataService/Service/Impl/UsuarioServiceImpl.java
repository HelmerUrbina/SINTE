package mil.sinte.DataService.Service.Impl;

import mil.sinte.BusinessServices.Beans.BeanUsuario;
import mil.sinte.DataService.DAO.UsuarioDAO;
import mil.sinte.DataService.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired(required = true)
    private UsuarioDAO usuarioDAO;

    @Override
    public BeanUsuario findByUsername(String usuario) {
        return usuarioDAO.findByUsuario(usuario);
    }

    @Override
    public BeanUsuario findByUsernameAndEstado(String usuario, String estado) {
        return usuarioDAO.findByUsuarioAndEstado(usuario, estado);
    }

}
