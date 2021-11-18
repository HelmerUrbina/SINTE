/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanMarcas;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface MarcasService {
    
    public List<BeanMarcas> getMarcas();
    
    public BeanMarcas getMarca(String codigo);
    
    public String guardarMarcas(BeanMarcas objBeanMarcas, String usuario, String modo);
    
}
