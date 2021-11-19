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
    public List<BeanVehiculosBrigada> getVehiculosBrigadas(Integer brigada, String periodo) {
        return vehiculosBrigadaDAO.findAll(brigada, periodo);
    }

    @Override
    public BeanVehiculosBrigada getVehiculosBrigada(Integer brigada, String periodo) {
        return vehiculosBrigadaDAO.findByDetalle(brigada, periodo);
    }

    @Override
    public String guardarVehiculosBrigada(BeanVehiculosBrigada objBeanVehiculosBrigada, String usuario, String modo) {
        String result = "GUARDO";
        try {
            vehiculosBrigadaDAO.sp_vehiculos_brigadas(
                    objBeanVehiculosBrigada.getPeriodo(),
                    Integer.parseInt(objBeanVehiculosBrigada.getBrigada()),
                    Integer.parseInt(objBeanVehiculosBrigada.getDependencia()),
                    Integer.parseInt(objBeanVehiculosBrigada.getVehiculo()),
                    objBeanVehiculosBrigada.getFecha(),
                    usuario,
                    modo
            );
        } catch (Exception e) {
            result = Utiles.getErrorSQL(e);
        }
        return result;
    }

}
