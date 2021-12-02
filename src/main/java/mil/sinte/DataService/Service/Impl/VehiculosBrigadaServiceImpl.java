package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanVehiculosBrigada;
import mil.sinte.DataService.DAO.VehiculosBrigadaDAO;
import mil.sinte.DataService.Service.VehiculosBrigadasService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class VehiculosBrigadaServiceImpl implements VehiculosBrigadasService {

    @Autowired
    private VehiculosBrigadaDAO vehiculosBrigadaDAO;

    @Override
    public List<BeanVehiculosBrigada> getVehiculosBrigadas(String periodo, Integer brigada) {
        return vehiculosBrigadaDAO.findAll(periodo, brigada);
    }

    @Override
    public String guardarVehiculosBrigada(BeanVehiculosBrigada objBeanVehiculosBrigada, String usuario, String modo) {
        String result = "GUARDO";
        try {
            vehiculosBrigadaDAO.sp_vehiculosBrigadas(
                    objBeanVehiculosBrigada.getPeriodo(),
                    objBeanVehiculosBrigada.getBrigada(),
                    objBeanVehiculosBrigada.getDependencia(),
                    objBeanVehiculosBrigada.getVehiculo(),
                    objBeanVehiculosBrigada.getFecha(),
                    usuario,
                    modo
            );
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }

}
