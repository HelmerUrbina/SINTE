package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanBrigadas;
import mil.sinte.DataService.DAO.BrigadasDAO;
import mil.sinte.DataService.Service.BrigadasService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class BrigadasServiceImpl implements BrigadasService {

    @Autowired
    private BrigadasDAO brigadaDAO;

    @Override
    public List<BeanBrigadas> getBrigadas() {
        return brigadaDAO.findAll();
    }

    @Override
    public BeanBrigadas getBrigada(Integer codigo) {
        return brigadaDAO.findByCodigo(codigo);
    }

    @Override
    public String guardarBrigada(BeanBrigadas objBnBrigada, String usuario, String modo) {
        String result = "GUARDO";
        try {
            brigadaDAO.sp_brigada(
                    objBnBrigada.getCodigo(),
                    objBnBrigada.getBrigadaCodigo(),
                    objBnBrigada.getDivisionEjercito(),
                    objBnBrigada.getDescripcion(),
                    objBnBrigada.getAbreviatura(),
                    objBnBrigada.getUbigeo(),
                    usuario,
                    modo
            );
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }

}
