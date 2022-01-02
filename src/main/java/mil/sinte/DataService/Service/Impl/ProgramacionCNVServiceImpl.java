package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanProgramacionCNV;
import mil.sinte.DataService.DAO.ProgramacionCNVDAO;
import mil.sinte.DataService.Service.ProgramacionCNVService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class ProgramacionCNVServiceImpl implements ProgramacionCNVService {

    @Autowired
    private ProgramacionCNVDAO cnvDAO;

    @Override
    public List<BeanProgramacionCNV> getProgramacionCNV(String periodo, Integer tipoAsignacion, Integer brigada, Integer tipoCombustible, String eventoPrincipal, Integer eventoFinal) {
        return cnvDAO.findByPeriodoTipoAsignacionBrigadaEventoPrincipalEventoFinal(periodo, tipoAsignacion, brigada, tipoCombustible, eventoPrincipal, eventoFinal);
    }

    @Override
    public String guardarProgramacionCNV(BeanProgramacionCNV objBnProgramacionCNV, String usuario, String modo) {
        String result = "GUARDO";
        try {
            cnvDAO.sp_programacionCNV(
                    objBnProgramacionCNV.getPeriodo(),
                    objBnProgramacionCNV.getTipoAsignacion(),
                    objBnProgramacionCNV.getBrigada(),
                    objBnProgramacionCNV.getTipoCombustible(),
                    objBnProgramacionCNV.getEventoPrincipal(),
                    objBnProgramacionCNV.getEventoFinal(),
                    objBnProgramacionCNV.getCodigo(),
                    objBnProgramacionCNV.getDependencia(),
                    objBnProgramacionCNV.getVehiculo(),
                    objBnProgramacionCNV.getCantidad(),
                    objBnProgramacionCNV.getPrecio(),
                    objBnProgramacionCNV.getDemandaGlobal(),
                    usuario,
                    modo
            );
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }

}
