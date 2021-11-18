package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanMarcas;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface MarcasService {

    public List<BeanMarcas> getMarcas();

    public BeanMarcas getMarca(String codigo);

    public String guardarMarcas(BeanMarcas objBeanMarcas, String usuario, String modo);

}
