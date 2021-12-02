/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanAsignacionCombustible;
import mil.sinte.BusinessServices.Beans.BeanMatrizAsignacion;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface AsignacionCombustibleService {

    public List<BeanAsignacionCombustible> getAsignacionCombustibles(String periodo, String brigada, String mes, String tipoAsignacion);

    public List<BeanMatrizAsignacion> getMatrizAsignacion(String periodo, String mes, String tipoAsignacion);

    public String guardarAsignacionCombustible(BeanAsignacionCombustible objAsignacionCombustible, String usuario, String modo);

    public String guardarAsignacionCombustibleAprobacion(BeanAsignacionCombustible objAsignacionCombustible, String usuario, String modo);
    
    public String guardarAsignacionCombustibleAprobacion2(BeanAsignacionCombustible objAsignacionCombustible, String usuario, String modo);

}
