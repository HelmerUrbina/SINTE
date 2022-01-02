package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanProgramacionEventoPrincipal;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface ProgramacionEventoPrincipalService {

    public List<BeanProgramacionEventoPrincipal> getProgramacionEventoPrincipal(String periodo, Integer tipoAsignacion, Integer brigada, Integer tipoCombustible);

    public List<BeanProgramacionEventoPrincipal> getProgramacionEventosSecundarios(String periodo, Integer tipoAsignacion, Integer brigada, Integer tipoCombustible, String eventoPrincipal, Integer nivel);

    public String guardarProgramacionEventoPrincipal(BeanProgramacionEventoPrincipal objBnProgramacionEventPrincipal, String usuario, String modo);

}
