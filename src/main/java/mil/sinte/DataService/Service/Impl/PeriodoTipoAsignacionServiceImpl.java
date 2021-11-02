package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanPeriodoTipoAsignacion;
import mil.sinte.DataService.DAO.PeriodoTipoAsignacionDAO;
import mil.sinte.DataService.Service.PeriodoTipoAsignacionService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class PeriodoTipoAsignacionServiceImpl implements PeriodoTipoAsignacionService {

    @Autowired
    private PeriodoTipoAsignacionDAO periodoTipoAsignacionDAO;

    @Override
    public List<BeanPeriodoTipoAsignacion> getPeriodoTipoAsignacion(String periodo) {
        return periodoTipoAsignacionDAO.findByPeriodo(periodo);
    }

    @Override
    public String guardarPeriodoTipoAsignacion(BeanPeriodoTipoAsignacion objBnPeriodoTipoAsignacion, String usuario, String modo) {
        String result = "GUARDO";
        try {
            periodoTipoAsignacionDAO.sp_periodoTipoAsignacion(
                    objBnPeriodoTipoAsignacion.getPeriodo(),
                    objBnPeriodoTipoAsignacion.getTipoAsignacion(),
                    usuario,
                    modo
            );
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }

}
