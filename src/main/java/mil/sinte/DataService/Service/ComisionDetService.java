/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanComisionDet;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface ComisionDetService {
    
    public List<BeanComisionDet> findAll(Integer codigo);
    
}
