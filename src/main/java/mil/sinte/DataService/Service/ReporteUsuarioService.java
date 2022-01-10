/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanReporteUsuario;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface ReporteUsuarioService {
    
    public List<BeanReporteUsuario> getReportesByusuarios(String periodo, String reporte);
    
    public String guardarReportes(BeanReporteUsuario obj, String usuario, String mode);
    
}
