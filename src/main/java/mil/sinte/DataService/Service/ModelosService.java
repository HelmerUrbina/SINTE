package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanModelos;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface ModelosService {

    public List<BeanModelos> getModelos();

    public BeanModelos getModelo(String modelo);

    public String guardarModelos(BeanModelos objBeanModelos, String usuario, String modo);

}
