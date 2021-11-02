package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanPeriodos;
import mil.sinte.DataService.DAO.PeriodosDAO;
import mil.sinte.DataService.Service.PeriodosService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class PeriodosServiceImpl implements PeriodosService {

    @Autowired
    private PeriodosDAO periodoDAO;

    @Override
    public List<BeanPeriodos> getPeriodos() {
        return periodoDAO.findAll();
    }

    @Override
    public BeanPeriodos getPeriodos(String codigo) {
        return periodoDAO.findByCodigo(codigo);
    }

    @Override
    public String guardarPeriodos(BeanPeriodos objBnPeriodo, String usuario, String modo) {
        String result = "GUARDO";
        try {
            periodoDAO.sp_periodo(
                    objBnPeriodo.getCodigo(),
                    objBnPeriodo.getDescripcion(),
                    objBnPeriodo.getAbreviatura(),
                    usuario,
                    modo);
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }
}
