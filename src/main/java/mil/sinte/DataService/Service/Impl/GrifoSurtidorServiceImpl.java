package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanGrifoSurtidor;
import mil.sinte.DataService.DAO.GrifoSurtidorDAO;
import mil.sinte.DataService.Service.GrifoSurtidorService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class GrifoSurtidorServiceImpl implements GrifoSurtidorService {

    @Autowired
    private GrifoSurtidorDAO grifoSurtidorDAO;

    @Override
    public List<BeanGrifoSurtidor> getGrifoSurtidores(Integer grifo) {
        return grifoSurtidorDAO.findByGrifo(grifo);
    }

    @Override
    public BeanGrifoSurtidor getGrifoSurtidor(Integer grifo, Integer grifoSurtidor) {
        return grifoSurtidorDAO.findByGrifoSurtidor(grifo, grifoSurtidor);
    }

    @Override
    public String guardarGrifoSurtidor(BeanGrifoSurtidor objBnGrifoSurtidor, String usuario, String modo) {
        String result = "GUARDO";
        try {
            grifoSurtidorDAO.sp_grifoSurtidor(
                    objBnGrifoSurtidor.getGrifo(),
                    objBnGrifoSurtidor.getGrifoSurtidor(),
                    objBnGrifoSurtidor.getTipoCombustible(),
                    objBnGrifoSurtidor.getSurtidor(),
                    objBnGrifoSurtidor.getCapacidad(),
                    usuario,
                    modo
            );
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }

}
