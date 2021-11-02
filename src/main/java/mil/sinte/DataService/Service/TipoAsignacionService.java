package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanTipoAsignacion;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface TipoAsignacionService {

    public List<BeanTipoAsignacion> getTipoAsignacion();

    public BeanTipoAsignacion getTipoAsignacion(Integer codigo);

    public String guardarTipoAsignacion(BeanTipoAsignacion objBnTipoAsignacion, String usuario, String modo);
}
