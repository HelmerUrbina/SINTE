/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanVariacion;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface VariacionService {
   
    public List<BeanVariacion> getVariaciones(String periodo, Integer brigada, String mes);
    
    public String guardarVariacion(BeanVariacion objBeanVariacion, String usuario, String modo);
    
}
