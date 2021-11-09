package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanUsuario;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface UsuarioService {

    public BeanUsuario findByUsername(String usuario);

    public BeanUsuario findByUsernameAndEstado(String usuario, String estado);
    
    public List<BeanUsuario> findAll();
    
    public BeanUsuario findByCodigo(String usuario);
    
    public String guardarUsuario(BeanUsuario objBeanUsuario, String usuario, String modo);
}
