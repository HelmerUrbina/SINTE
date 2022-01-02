package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanProgramacionClaseIIITechos;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface ProgramacionClaseIIITechosService {

    public List<BeanProgramacionClaseIIITechos> getProgramacionClaseIIITechos(String periodo, Integer tipoAsignacion, Integer tipoCombustible);

    public String guardarProgramacionClaseIIITechos(BeanProgramacionClaseIIITechos objBnProgramacionClaseIII, String usuario, String modo);

}
