package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanTipoDependencia;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface TipoDependenciaService {

    public List<BeanTipoDependencia> getTipoDependencia();

    public BeanTipoDependencia getTipoDependencia(Integer codigo);

    public String guardarTipoDependencia(BeanTipoDependencia objBnTipoDependencia, String usuario, String modo);
}
