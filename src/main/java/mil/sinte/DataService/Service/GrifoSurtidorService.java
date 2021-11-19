package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanGrifoSurtidor;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface GrifoSurtidorService {

    public List<BeanGrifoSurtidor> getGrifoSurtidores(Integer grifo);

    public BeanGrifoSurtidor getGrifoSurtidor(Integer grifo, Integer grifoSurtidor);

    public String guardarGrifoSurtidor(BeanGrifoSurtidor objBnGrifoSurtidor, String usuario, String modo);
}
