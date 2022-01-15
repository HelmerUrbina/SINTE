package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanTipoOperacion;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface TipoOperacionService {

    public List<BeanTipoOperacion> getTipoOperacion();

    public String guardarTipoOperacion(BeanTipoOperacion objBnTipoOperacion, String usuario, String modo);

}
