/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanFirmaUsuario;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface FirmaUsuarioService {
    
    public List<BeanFirmaUsuario> getFirmas(String periodo);
    
    public String guardarFirma(BeanFirmaUsuario obj, String usuario, String modo);
    
}
