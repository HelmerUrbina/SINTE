package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanReportes;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface ReportesService {

    public List<BeanReportes> getReportes();

    public String guardarReportes(BeanReportes objBnReportes, String usuario, String modo);

}
