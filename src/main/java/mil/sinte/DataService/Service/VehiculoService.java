package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanVehiculoSoat;
import mil.sinte.BusinessServices.Beans.BeanVehiculoTipoCombustible;
import mil.sinte.BusinessServices.Beans.BeanVehiculos;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface VehiculoService {

    public List<BeanVehiculos> getVehiculos();

    public BeanVehiculos getVehiculo(Integer codigo);

    public String guardarVehiculo(BeanVehiculos objBeanVehiculo, String usuario, String modo);

    public List<BeanVehiculoTipoCombustible> getVehiculoTiposCombustibles(Integer vehiculo);

    public String guardarVehiculoTipoCombustible(BeanVehiculoTipoCombustible objBeanVehiculoTipoCombustible, String usuario, String modo);

    public List<BeanVehiculoSoat> getVehiculoSoats(Integer vehiculo);

    public String guardarVehiculoSoat(BeanVehiculoSoat objBeanVehiculoSoat, String usuario, String modo);
}
