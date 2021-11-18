package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanColores;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface ColoresService {

    public List<BeanColores> getColores();

    public BeanColores getColor(String codigo);

    public String guardarColores(BeanColores objBeanColores, String usuario, String modo);

}
