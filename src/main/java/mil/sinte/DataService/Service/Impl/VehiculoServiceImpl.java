package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanVehiculoSoat;
import mil.sinte.BusinessServices.Beans.BeanVehiculoTipoCombustible;
import mil.sinte.BusinessServices.Beans.BeanVehiculos;
import mil.sinte.DataService.DAO.VehiculoDAO;
import mil.sinte.DataService.DAO.VehiculoSoatDAO;
import mil.sinte.DataService.DAO.VehiculoTipoCombustibleDAO;
import mil.sinte.DataService.Service.VehiculoService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoDAO vehiculoDAO;

    @Autowired
    private VehiculoTipoCombustibleDAO vehiculoTipoCombustibleDAO;

    @Autowired
    private VehiculoSoatDAO vehiculoSoatDAO;

    @Override
    public List<BeanVehiculos> getVehiculos() {
        return vehiculoDAO.findAll();
    }

    @Override
    public BeanVehiculos getVehiculo(Integer codigo) {
        return vehiculoDAO.findByCodigo(codigo);
    }

    @Override
    public String guardarVehiculo(BeanVehiculos objBeanVehiculo, String usuario, String modo) {
        String result = "GUARDO";
        try {
            vehiculoDAO.sp_vehiculo(
                    objBeanVehiculo.getCodigo(),
                    objBeanVehiculo.getPlaca(),
                    objBeanVehiculo.getSerieChasis(),
                    objBeanVehiculo.getSerieMotor(),
                    objBeanVehiculo.getTipo() != null ? Integer.parseInt(objBeanVehiculo.getTipo()) : null,
                    objBeanVehiculo.getClase() != null ? Integer.parseInt(objBeanVehiculo.getClase()) : null,
                    objBeanVehiculo.getMarca() != null ? Integer.parseInt(objBeanVehiculo.getMarca()) : null,
                    objBeanVehiculo.getModelo() != null ? Integer.parseInt(objBeanVehiculo.getModelo()) : null,
                    objBeanVehiculo.getTransmision(),
                    objBeanVehiculo.getFabricacion(),
                    objBeanVehiculo.getPuertas(),
                    objBeanVehiculo.getColor() != null ? Integer.parseInt(objBeanVehiculo.getColor()) : null,
                    usuario,
                    modo
            );
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }

    @Override
    public List<BeanVehiculoTipoCombustible> getVehiculoTiposCombustibles(Integer vehiculo) {
        return vehiculoTipoCombustibleDAO.findByVehiculo(vehiculo);
    }

    @Override
    public String guardarVehiculoTipoCombustible(BeanVehiculoTipoCombustible objBeanVehiculoTipoCombustible, String usuario, String modo) {
        String result = "GUARDO";
        try {
            vehiculoTipoCombustibleDAO.sp_vehiculo_tipo_combustible(
                    objBeanVehiculoTipoCombustible.getVehiculo() != null ? Integer.parseInt(objBeanVehiculoTipoCombustible.getVehiculo()) : null,
                    objBeanVehiculoTipoCombustible.getTipoCombustible(),
                    objBeanVehiculoTipoCombustible.getCapacidad(),
                    usuario,
                    modo
            );
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }

    @Override
    public List<BeanVehiculoSoat> getVehiculoSoats(Integer vehiculo) {
        return vehiculoSoatDAO.findByVehiculo(vehiculo);
    }

    @Override
    public String guardarVehiculoSoat(BeanVehiculoSoat objBeanVehiculoSoat, String usuario, String modo) {
        String result = "GUARDO";
        try {
            vehiculoSoatDAO.sp_vehiculo_soat(
                    objBeanVehiculoSoat.getVehiculo() != null ? Integer.parseInt(objBeanVehiculoSoat.getVehiculo()) : null,
                    objBeanVehiculoSoat.getCodigo(),
                    objBeanVehiculoSoat.getAseguradora() != null ? Integer.parseInt(objBeanVehiculoSoat.getAseguradora()) : null,
                    objBeanVehiculoSoat.getTipo(),
                    objBeanVehiculoSoat.getCertificado(),
                    objBeanVehiculoSoat.getInicio(),
                    objBeanVehiculoSoat.getFin(),
                    usuario,
                    modo
            );
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }

}
