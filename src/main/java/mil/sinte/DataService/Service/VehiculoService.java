/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public String guardarVehiculo (BeanVehiculos objBeanVehiculo, String usuario, String modo);
    
    public List<BeanVehiculoTipoCombustible> getVehiculoTiposCombustibles(Integer vehiculo);
    
    public BeanVehiculoTipoCombustible getVehiculoTipoCombustible(Integer vehiculo, Integer codigo);
    
    public String guardarVehiculoTipoCombustible (BeanVehiculoTipoCombustible objBeanVehiculoTipoCombustible, String usuario, String modo);
    
    public List<BeanVehiculoSoat> getVehiculoSoats(Integer vehiculo);
    
    public BeanVehiculoSoat getVehiculoSoat(Integer vehiculo, Integer codigo);
    
    public String guardarVehiculoSoat (BeanVehiculoSoat objBeanVehiculoSoat, String usuario, String modo);
}
