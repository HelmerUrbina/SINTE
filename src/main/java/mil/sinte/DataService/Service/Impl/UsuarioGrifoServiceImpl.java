package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanUsuarioGrifo;
import mil.sinte.DataService.DAO.UsuarioGrifoDAO;
import mil.sinte.DataService.Service.UsuarioGrifoService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class UsuarioGrifoServiceImpl implements UsuarioGrifoService {

    @Autowired
    private UsuarioGrifoDAO usuarioGrifoDAO;

    @Override
    public List<BeanUsuarioGrifo> getUsuariosGrifo(String periodo, Integer grifo) {
        return usuarioGrifoDAO.findByPeriodoAndGrifo(periodo, grifo);
    }

    @Override
    public String guardarUsuariosGrifo(BeanUsuarioGrifo objBnUsuarioGrifo, String usuario, String modo) {
        String result = "GUARDO";
        try {
            usuarioGrifoDAO.sp_usuarioGrifo(
                    objBnUsuarioGrifo.getPeriodo(),
                    objBnUsuarioGrifo.getUsuario(),
                    Utiles.checkNum(objBnUsuarioGrifo.getGrifo()),
                    usuario,
                    modo
            );
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }

}
