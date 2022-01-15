package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanProgramacionEventoFinal;
import mil.sinte.DataService.DAO.ProgramacionEventoFinalDAO;
import mil.sinte.DataService.Service.ProgramacionEventoFinalService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class ProgramacionEventoFinalServiceImpl implements ProgramacionEventoFinalService {

    @Autowired
    private ProgramacionEventoFinalDAO eventoPrincipalDAO;

    @Override
    public List<BeanProgramacionEventoFinal> getProgramacionEventoFinal(String periodo, Integer tipoAsignacion, Integer brigada, Integer tipoCombustible, String eventoFinal) {
        return eventoPrincipalDAO.findByPeriodoTipoAsignacionBrigadaEventoPrincipal(periodo, tipoAsignacion, brigada, tipoCombustible, eventoFinal);
    }

    @Override
    public String guardarProgramacionEventoFinal(BeanProgramacionEventoFinal objBnProgramacionEventoFinal, String usuario, String modo) {
        String result = "GUARDO";
        try {
            eventoPrincipalDAO.sp_programacionEventoFinal(
                    objBnProgramacionEventoFinal.getPeriodo(),
                    objBnProgramacionEventoFinal.getTipoAsignacion(),
                    objBnProgramacionEventoFinal.getBrigada(),
                    objBnProgramacionEventoFinal.getTipoCombustible(),
                    objBnProgramacionEventoFinal.getEventoPrincipal(),
                    objBnProgramacionEventoFinal.getEventoFinal(),
                    objBnProgramacionEventoFinal.getEventoFinalNombre(),
                    objBnProgramacionEventoFinal.getPrioridad(),
                    Utiles.checkNum(objBnProgramacionEventoFinal.getTipoOperacion()),
                    usuario,
                    modo
            );
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }

}
