/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanAsignacionCombustibleD;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface AsignacionCombustibleDService {
    
    public List<BeanAsignacionCombustibleD> getAsignacionCombustibleDs(String periodo, String brigada, String mes, String tipoAsignacion, String tipoCombustible);
    
    public List<BeanAsignacionCombustibleD> getAsignacionCombustibleA(String periodo, String brigada, String mes, String tipoAsignacion, String tipoCombustible);
    
    public String guardarAsignacionCombustibleD(BeanAsignacionCombustibleD objAsignacionCombustibleD, String usuario, String modo);
    
    public String guardarAsignacionCombustibleA(BeanAsignacionCombustibleD objAsignacionCombustibleD, String usuario, String modo);
    
}
