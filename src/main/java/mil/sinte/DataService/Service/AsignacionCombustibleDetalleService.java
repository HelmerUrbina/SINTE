package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanAsignacionCombustibleDetalle;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface AsignacionCombustibleDetalleService {

    public List<BeanAsignacionCombustibleDetalle> getAsignacionCombustibleDetalle(String periodo, String brigada, String mes, String tipoAsignacion, String tipoCombustible);

    public List<BeanAsignacionCombustibleDetalle> getAsignacionCombustibleDetalleAprobacion(String periodo, String brigada, String mes, String tipoAsignacion, String tipoCombustible);

    public String guardarAsignacionCombustibleDetalle(BeanAsignacionCombustibleDetalle objBnAsignacionDetalle, String usuario, String modo);

    public String guardarAsignacionCombustibleAprobacion(BeanAsignacionCombustibleDetalle objBnAsignacionDetalle, String usuario, String modo);

}
