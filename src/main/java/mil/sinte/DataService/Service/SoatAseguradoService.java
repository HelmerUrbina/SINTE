/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanSoatAseguradora;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface SoatAseguradoService {
    
    public List<BeanSoatAseguradora> getSoatAseguradoras();
    
    public BeanSoatAseguradora getSoatAseguradora(String codigo);
    
    public String guardarSoatAseguradora(BeanSoatAseguradora objAseguradora, String usuario, String modo);
}
