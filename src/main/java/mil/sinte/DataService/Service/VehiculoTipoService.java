/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanVehiculoTipo;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface VehiculoTipoService {

    public List<BeanVehiculoTipo> getVehiculoTipos();
    
    public BeanVehiculoTipo getVehiculoTipo(String codigo);
    
    public String guardarVehiculoTipo(BeanVehiculoTipo objBeanVehiculoTipo, String usuario, String modo);
    
}
