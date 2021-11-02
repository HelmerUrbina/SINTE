package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanAreaLaboral;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface AreaLaboralService {

    public List<BeanAreaLaboral> getAreaLaboral();

    public BeanAreaLaboral getAreaLaboral(Integer codigo);

    public String guardarAreaLaboral(BeanAreaLaboral objBnAreaLaboral, String usuario, String modo);
}
