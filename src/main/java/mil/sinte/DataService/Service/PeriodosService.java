package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanPeriodos;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface PeriodosService {

    public List<BeanPeriodos> getPeriodos();

    public BeanPeriodos getPeriodos(String codigo);

    public String guardarPeriodos(BeanPeriodos objBnPeriodo, String usuario, String modo);
}
