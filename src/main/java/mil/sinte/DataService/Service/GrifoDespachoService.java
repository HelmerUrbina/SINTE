package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanGrifoDespacho;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface GrifoDespachoService {

    public List<BeanGrifoDespacho> getDespachoByPlaca(String placa);
}
