package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanAreaLaboral;
import mil.sinte.DataService.DAO.AreaLaboralDAO;
import mil.sinte.DataService.Service.AreaLaboralService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class AreaLaboralServiceImpl implements AreaLaboralService {

    @Autowired
    private AreaLaboralDAO areaLaboralDAO;

    @Override
    public List<BeanAreaLaboral> getAreaLaboral() {
        return areaLaboralDAO.findAll();
    }

    @Override
    public BeanAreaLaboral getAreaLaboral(Integer codigo) {
        return areaLaboralDAO.findByCodigo(codigo);
    }

    @Override
    public String guardarAreaLaboral(BeanAreaLaboral objBnAreaLaboral, String usuario, String modo) {
        String result = "GUARDO";
        try {
            areaLaboralDAO.sp_areaLaboral(
                    objBnAreaLaboral.getCodigo(),
                    objBnAreaLaboral.getDescripcion(),
                    objBnAreaLaboral.getAbreviatura(),
                    usuario,
                    modo);
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }
}
