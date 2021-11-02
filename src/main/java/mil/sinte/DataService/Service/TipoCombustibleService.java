package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanTipoCombustible;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface TipoCombustibleService {

    public List<BeanTipoCombustible> getTipoCombustible();

    public BeanTipoCombustible getTipoCombustible(Integer codigo);

    public String guardarTipoCombustible(BeanTipoCombustible objBnTipoCombustible, String usuario, String modo);

}
