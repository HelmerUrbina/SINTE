package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanVehiculosClase;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface VehiculosClaseService {

    public List<BeanVehiculosClase> getVehiculosClases();

    public String guardarVehiculosClase(BeanVehiculosClase objBeanVehiculosClase, String usuario, String modo);

}
