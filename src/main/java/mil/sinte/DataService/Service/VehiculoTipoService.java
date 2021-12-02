package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanVehiculoTipo;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface VehiculoTipoService {

    public List<BeanVehiculoTipo> getVehiculoTipos();

    public String guardarVehiculoTipo(BeanVehiculoTipo objBeanVehiculoTipo, String usuario, String modo);

}
