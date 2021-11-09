/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanVehiculoTipoCombustible;
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
