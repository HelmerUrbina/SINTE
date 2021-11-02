package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanDependencia;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface DependenciaService {

    public List<BeanDependencia> getDependencias(Integer brigada);

    public BeanDependencia getDependencia(Integer brigada, Integer codigo);

    public String guardarDependencia(BeanDependencia objBnDependencia, String usuario, String modo);
}
