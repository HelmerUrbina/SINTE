/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanUsuarioGrifo;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface UsuarioGrifoService {
    
    public List<BeanUsuarioGrifo> getUsuario(Integer grifo, String periodo); 
    
    public String guardarUsuarioGrifo(BeanUsuarioGrifo obj, String usuario, String modo);
    
}
