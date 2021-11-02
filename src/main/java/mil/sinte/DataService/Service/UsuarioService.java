package mil.sinte.DataService.Service;

import mil.sinte.BusinessServices.Beans.BeanUsuario;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface UsuarioService {

    public BeanUsuario findByUsername(String usuario);

    public BeanUsuario findByUsernameAndEstado(String usuario, String estado);
}
