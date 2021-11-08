package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanUsuario;
import mil.sinte.DataService.DAO.UsuarioDAO;
import mil.sinte.DataService.Service.UsuarioService;
import mil.sinte.Utiles.Utiles;
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

    @Override
    public List<BeanUsuario> findAll() {
        return usuarioDAO.findAll();
    }

    @Override
    public BeanUsuario findByCodigo(String usuario) {
        return usuarioDAO.findByCodigo(usuario);
    }

    @Override
    public String guardarUsuario(BeanUsuario objBeanUsuario, String usuario, String modo) {
        String result = "GUARDO";
        try {

            usuarioDAO.sp_usuario(
                    objBeanUsuario.getUsuario(),
                    objBeanUsuario.getAreaLaboral()!=null?Integer.parseInt(objBeanUsuario.getAreaLaboral()):null, 
                    objBeanUsuario.getRol()!=null?Integer.parseInt(objBeanUsuario.getRol()):null, 
                    objBeanUsuario.getBrigada()!=null?Integer.parseInt(objBeanUsuario.getBrigada()):null, 
                    objBeanUsuario.getPaterno(), 
                    objBeanUsuario.getMaterno(), 
                    objBeanUsuario.getNombres(), 
                    objBeanUsuario.getCorreo(),
                    objBeanUsuario.getTelefono(),
                    objBeanUsuario.getCargo(),
                    0,
                    usuario, 
                    modo
            );
        } catch (Exception e) {
            result = e.getCause().getMessage();
//            result = Utiles.getErrorSQL(e);
        }
        return result;
    }

}
