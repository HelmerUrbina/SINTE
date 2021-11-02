package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanDivisionEjercito;
import mil.sinte.DataService.DAO.DivisionEjercitoDAO;
import mil.sinte.DataService.Service.DivisionEjercitoService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class DivisionEjercitoServiceImpl implements DivisionEjercitoService {

    @Autowired
    private DivisionEjercitoDAO divisionEjercitoDAO;

    @Override
    public List<BeanDivisionEjercito> getDivisionEjercito() {
        return divisionEjercitoDAO.findAll();
    }

    @Override
    public BeanDivisionEjercito getDivisionEjercito(Integer codigo) {
        return divisionEjercitoDAO.findByCodigo(codigo);
    }

    @Override
    public String guardarDivisionEjercito(BeanDivisionEjercito objBnDivisionEjercito, String usuario, String modo) {
        String result = "GUARDO";
        try {
            divisionEjercitoDAO.sp_divisionEjercito(
                    objBnDivisionEjercito.getCodigo(),
                    objBnDivisionEjercito.getDescripcion(),
                    objBnDivisionEjercito.getAbreviatura(),
                    usuario,
                    modo);
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }

}
