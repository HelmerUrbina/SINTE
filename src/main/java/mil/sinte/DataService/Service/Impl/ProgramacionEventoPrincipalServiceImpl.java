package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanProgramacionEventoPrincipal;
import mil.sinte.DataService.DAO.ProgramacionEventoPrincipalDAO;
import mil.sinte.DataService.Service.ProgramacionEventoPrincipalService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class ProgramacionEventoPrincipalServiceImpl implements ProgramacionEventoPrincipalService {

    @Autowired
    private ProgramacionEventoPrincipalDAO eventoPrincipalDAO;

    @Override
    public List<BeanProgramacionEventoPrincipal> getProgramacionEventoPrincipal(String periodo, Integer tipoAsignacion, Integer brigada) {
        return eventoPrincipalDAO.findByPeriodoTipoAsignacionBrigada(periodo, tipoAsignacion, brigada);
    }

    @Override
    public List<BeanProgramacionEventoPrincipal> getProgramacionEventosSecundarios(String periodo, Integer tipoAsignacion, Integer brigada, String eventoPrincipal, Integer nivel) {
        return eventoPrincipalDAO.findByPeriodoTipoAsignacionBrigadaEventoPrincipalNivel(periodo, tipoAsignacion, brigada, eventoPrincipal, nivel);
    }

    @Override
    public String guardarProgramacionEventoPrincipal(BeanProgramacionEventoPrincipal objBnProgramacionEventoPrincipal, String usuario, String modo) {
        String result = "GUARDO";
        try {
            eventoPrincipalDAO.sp_programacionEventoPrincipal(
                    objBnProgramacionEventoPrincipal.getPeriodo(),
                    objBnProgramacionEventoPrincipal.getTipoAsignacion(),
                    objBnProgramacionEventoPrincipal.getBrigada(),
                    objBnProgramacionEventoPrincipal.getEventoPrincipal(),
                    objBnProgramacionEventoPrincipal.getEventoPrincipalNombre(),
                    objBnProgramacionEventoPrincipal.getNivel(),
                    objBnProgramacionEventoPrincipal.getNiveles(),
                    Utiles.checkNum(objBnProgramacionEventoPrincipal.getIsFinal()),
                    usuario,
                    modo
            );
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }

}
