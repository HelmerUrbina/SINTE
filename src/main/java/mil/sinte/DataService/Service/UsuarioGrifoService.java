package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanUsuarioGrifo;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface UsuarioGrifoService {

    public List<BeanUsuarioGrifo> getUsuariosGrifo(String periodo, Integer grifo);

    public String guardarUsuariosGrifo(BeanUsuarioGrifo objBnUsuarioGrifo, String usuario, String modo);

}
