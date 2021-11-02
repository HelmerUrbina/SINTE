package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanBrigadas;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface BrigadasService {

    public List<BeanBrigadas> getBrigadas();

    public BeanBrigadas getBrigada(Integer codigo);

    public String guardarBrigada(BeanBrigadas objBnBrigada, String usuario, String modo);
}
