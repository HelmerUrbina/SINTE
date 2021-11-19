package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanSoatAseguradora;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface SoatAseguradoService {

    public List<BeanSoatAseguradora> getSoatAseguradoras();

    public BeanSoatAseguradora getSoatAseguradora(String codigo);

    public String guardarSoatAseguradora(BeanSoatAseguradora objAseguradora, String usuario, String modo);
}
