package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanProgramacionCNV;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface ProgramacionCNVService {

    public List<BeanProgramacionCNV> getProgramacionCNV(String periodo, Integer tipoAsignacion, Integer brigada, String eventoPrincipal, Integer eventoFinal);

    public String guardarProgramacionCNV(BeanProgramacionCNV objBnProgramacionCNV, String usuario, String modo);

}
