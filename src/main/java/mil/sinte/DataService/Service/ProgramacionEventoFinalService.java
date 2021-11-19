package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanProgramacionEventoFinal;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface ProgramacionEventoFinalService {

    public List<BeanProgramacionEventoFinal> getProgramacionEventoFinal(String periodo, Integer tipoAsignacion, Integer brigada, String eventoPrincipal);

    public String guardarProgramacionEventoFinal(BeanProgramacionEventoFinal objBnProgramacionEventFinal, String usuario, String modo);

}
