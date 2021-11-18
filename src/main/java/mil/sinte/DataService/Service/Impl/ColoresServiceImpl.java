package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanColores;
import mil.sinte.DataService.DAO.ColoresDAO;
import mil.sinte.DataService.Service.ColoresService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class ColoresServiceImpl implements ColoresService {

    @Autowired
    private ColoresDAO coloresDAO;

    @Override
    public List<BeanColores> getColores() {
        return coloresDAO.findAll();
    }

    @Override
    public BeanColores getColor(String codigo) {
        return coloresDAO.findByCodigo(Integer.parseInt(codigo));
    }

    @Override
    public String guardarColores(BeanColores objBeanColores, String usuario, String modo) {
        String result = "GUARDO";
        try {
            coloresDAO.sp_colores(
                    Integer.parseInt(objBeanColores.getCodigo()),
                    objBeanColores.getDescripcion(),
                    usuario,
                    modo
            );
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }

}
