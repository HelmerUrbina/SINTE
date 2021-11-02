package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanTipoAsignacion;
import mil.sinte.DataService.DAO.TipoAsignacionDAO;
import mil.sinte.DataService.Service.TipoAsignacionService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class TipoAsignacionServiceImpl implements TipoAsignacionService {

    @Autowired
    private TipoAsignacionDAO tipoAsignacion;

    @Override
    public List<BeanTipoAsignacion> getTipoAsignacion() {
        return tipoAsignacion.findAll();
    }

    @Override
    public BeanTipoAsignacion getTipoAsignacion(Integer codigo) {
        return tipoAsignacion.findByCodigo(codigo);
    }

    @Override
    public String guardarTipoAsignacion(BeanTipoAsignacion objBnTipoAsignacion, String usuario, String modo) {
        String result = "GUARDO";
        try {
            tipoAsignacion.sp_tipoAsignacion(
                    objBnTipoAsignacion.getCodigo(),
                    objBnTipoAsignacion.getDescripcion(),
                    objBnTipoAsignacion.getAbreviatura(),
                    usuario,
                    modo);
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }
}
