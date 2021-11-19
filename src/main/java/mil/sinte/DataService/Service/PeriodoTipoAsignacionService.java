package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanPeriodoTipoAsignacion;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface PeriodoTipoAsignacionService {

    public List<BeanPeriodoTipoAsignacion> getPeriodoTipoAsignacion(String periodo);

    public String guardarPeriodoTipoAsignacion(BeanPeriodoTipoAsignacion objBnPeriodoTipoAsignacion, String usuario, String modo);
}
