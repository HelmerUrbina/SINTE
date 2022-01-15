package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanAsignacionCombustibleDetalle;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mil.sinte.DataService.DAO.AsignacionCombustibleDetalleDAO;
import mil.sinte.DataService.Service.AsignacionCombustibleDetalleService;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class AsignacionCombustibleDetalleServiceImpl implements AsignacionCombustibleDetalleService {

    @Autowired
    private AsignacionCombustibleDetalleDAO asignacionCombustibleDDAO;

    @Override
    public List<BeanAsignacionCombustibleDetalle> getAsignacionCombustibleDetalle(String periodo, String brigada, String mes, String tipoAsignacion, String tipoCombustible) {
        return asignacionCombustibleDDAO.findAll(periodo, Integer.parseInt(brigada), mes, Integer.parseInt(tipoAsignacion), Integer.parseInt(tipoCombustible));
    }

    @Override
    public List<BeanAsignacionCombustibleDetalle> getAsignacionCombustibleDetalleAprobacion(String periodo, String brigada, String mes, String tipoAsignacion, String tipoCombustible) {
        return asignacionCombustibleDDAO.findAllAprobacion(periodo, Integer.parseInt(brigada), mes, Integer.parseInt(tipoAsignacion), Integer.parseInt(tipoCombustible));
    }

    @Override
    public String guardarAsignacionCombustibleDetalle(BeanAsignacionCombustibleDetalle objBnAsignacionDetalle, String usuario, String modo) {
        String result = "GUARDO";
        try {
            asignacionCombustibleDDAO.sp_asignacionCombustibleDetalle(
                    objBnAsignacionDetalle.getPeriodo(),
                    Utiles.checkNum(objBnAsignacionDetalle.getBrigada()),
                    objBnAsignacionDetalle.getMes(),
                    Utiles.checkNum(objBnAsignacionDetalle.getTipoAsignacion()),
                    Utiles.checkNum(objBnAsignacionDetalle.getTipoCombustible()),
                    Utiles.checkNum(objBnAsignacionDetalle.getDependencia()),
                    Utiles.checkNum(objBnAsignacionDetalle.getVehiculo()),
                    Utiles.checkNum(objBnAsignacionDetalle.getTipoOperacion()),
                    objBnAsignacionDetalle.getCantidad(),
                    objBnAsignacionDetalle.getSolicitado(),
                    usuario,
                    modo
            );
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }

    @Override
    public String guardarAsignacionCombustibleAprobacion(BeanAsignacionCombustibleDetalle objBnAsignacionDetalle, String usuario, String modo) {
        String result = "GUARDO";
        try {
            asignacionCombustibleDDAO.sp_asignacionCombustibleDetalleAprobacion(
                    objBnAsignacionDetalle.getPeriodo(),
                    Utiles.checkNum(objBnAsignacionDetalle.getBrigada()),
                    objBnAsignacionDetalle.getMes(),
                    Utiles.checkNum(objBnAsignacionDetalle.getTipoAsignacion()),
                    Utiles.checkNum(objBnAsignacionDetalle.getTipoCombustible()),
                    objBnAsignacionDetalle.getVehiculo(),
                    usuario,
                    modo
            );
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }

}
