package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanGrifo;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mil.sinte.DataService.DAO.GrifoDAO;
import mil.sinte.DataService.Service.GrifoService;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class GrifoServiceImpl implements GrifoService {

    @Autowired
    private GrifoDAO grifoDAO;

    @Override
    public List<BeanGrifo> getGrifos() {
        return grifoDAO.findAll();
    }

    @Override
    public BeanGrifo getGrifo(Integer codigo) {
        return grifoDAO.findByCodigo(codigo);
    }

    @Override
    public String guardarGrifo(BeanGrifo objBnGrifo, String usuario, String modo) {
        String result = "GUARDO";
        try {
            grifoDAO.sp_grifo(
                    objBnGrifo.getCodigo(),
                    objBnGrifo.getBrigada(),
                    objBnGrifo.getGrifoNombre(),
                    objBnGrifo.getUbigeo(),
                    usuario,
                    modo
            );
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }

}
