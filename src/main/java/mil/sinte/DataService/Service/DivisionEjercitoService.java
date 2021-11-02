package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanDivisionEjercito;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface DivisionEjercitoService {

    public List<BeanDivisionEjercito> getDivisionEjercito();

    public BeanDivisionEjercito getDivisionEjercito(Integer codigo);

    public String guardarDivisionEjercito(BeanDivisionEjercito objBnDivisionEjercito, String usuario, String modo);
}
