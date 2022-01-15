package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanReportes;
import mil.sinte.DataService.DAO.ReportesDAO;
import mil.sinte.DataService.Service.ReportesService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class ReportesServiceImpl implements ReportesService {

    @Autowired
    private ReportesDAO reportesDAO;

    @Override
    public List<BeanReportes> getReportes() {
        return reportesDAO.findAll();
    }

    @Override
    public String guardarReportes(BeanReportes objBnReportes, String usuario, String modo) {
        String result = "GUARDO";
        try {
            reportesDAO.sp_reportes(
                    objBnReportes.getCodigo(),
                    objBnReportes.getNombre(),
                    Utiles.checkNum(objBnReportes.getFirma()),
                    usuario,
                    modo);
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }
}
