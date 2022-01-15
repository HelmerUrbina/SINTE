
package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanComision;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface ComisionService {
    
    public List<BeanComision> findAll(String periodo, Integer brigada, String mes, Integer asignacion);
    
    public String guardarComision(BeanComision objBeanComision, String usuario, String modo);
}
