package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanTipoOperacion;
import mil.sinte.DataService.DAO.TipoOperacionDAO;
import mil.sinte.DataService.Service.TipoOperacionService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class TipoOperacionServiceImpl implements TipoOperacionService {

    @Autowired
    private TipoOperacionDAO tipoOperacionDAO;

    @Override
    public List<BeanTipoOperacion> getTipoOperacion() {
        return tipoOperacionDAO.findAll();
    }

    @Override
    public String guardarTipoOperacion(BeanTipoOperacion objBnTipoOperacion, String usuario, String modo) {
        String result = "GUARDO";
        try {
            tipoOperacionDAO.sp_tipoOperacion(
                    objBnTipoOperacion.getCodigo(),
                    objBnTipoOperacion.getDescripcion(),
                    objBnTipoOperacion.getAbreviatura(),
                    usuario,
                    modo);
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }

}
