/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanAsignacionCombustibleDetalle;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface AsignacionCombustibleDetalleService {
    
    public List<BeanAsignacionCombustibleDetalle> getAsignacionCombustibleDs(String periodo, String brigada, String mes, String tipoAsignacion, String tipoCombustible);
    
    public List<BeanAsignacionCombustibleDetalle> getAsignacionCombustibleA(String periodo, String brigada, String mes, String tipoAsignacion, String tipoCombustible);
    
    public String guardarAsignacionCombustibleD(BeanAsignacionCombustibleDetalle objAsignacionCombustibleD, String usuario, String modo);
    
    public String guardarAsignacionCombustibleA(BeanAsignacionCombustibleDetalle objAsignacionCombustibleD, String usuario, String modo);
    
}
