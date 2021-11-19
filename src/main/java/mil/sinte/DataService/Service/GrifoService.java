package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanGrifo;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface GrifoService {

    public List<BeanGrifo> getGrifos();

    public BeanGrifo getGrifo(Integer codigo);

    public String guardarGrifo(BeanGrifo objBnGrifo, String usuario, String modo);
}
