/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanVehiculosClase;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface VehiculosClaseService {
   
    public List<BeanVehiculosClase> getVehiculosClases();
    
    public BeanVehiculosClase getVehiculosClase(String codigo);
    
    public String guardarVehiculosClase(BeanVehiculosClase objBeanVehiculosClase, String usuario, String modo);
    
}
