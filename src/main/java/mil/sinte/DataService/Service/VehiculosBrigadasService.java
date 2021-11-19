package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanVehiculosBrigada;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface VehiculosBrigadasService {

    public List<BeanVehiculosBrigada> getVehiculosBrigadas(Integer brigada, String periodo);

    public BeanVehiculosBrigada getVehiculosBrigada(Integer brigada, String periodo);

    public String guardarVehiculosBrigada(BeanVehiculosBrigada objBeanVehiculosBrigada, String usuario, String modo);

}
