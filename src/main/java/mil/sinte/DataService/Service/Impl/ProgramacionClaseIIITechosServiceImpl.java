package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanProgramacionClaseIIITechos;
import mil.sinte.DataService.DAO.ProgramacionClaseIIITechosDAO;
import mil.sinte.DataService.Service.ProgramacionClaseIIITechosService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class ProgramacionClaseIIITechosServiceImpl implements ProgramacionClaseIIITechosService {

    @Autowired
    private ProgramacionClaseIIITechosDAO programacionClaseIII;

    @Override
    public List<BeanProgramacionClaseIIITechos> getProgramacionClaseIIITechos(String periodo, Integer tipoAsignacion, Integer tipoCombustible) {
        return programacionClaseIII.findByPeriodoAndTipoAsignacionAndTipoCombustible(periodo, tipoAsignacion, tipoCombustible);
    }

    @Override
    public String guardarProgramacionClaseIIITechos(BeanProgramacionClaseIIITechos objBnProgramacionClaseIII, String usuario, String modo) {
        String result = "GUARDO";
        try {
            programacionClaseIII.sp_programacionClaseIIITechos(
                    objBnProgramacionClaseIII.getPeriodo(),
                    objBnProgramacionClaseIII.getTipoAsignacion(),
                    objBnProgramacionClaseIII.getTipoCombustible(),
                    objBnProgramacionClaseIII.getBrigada(),
                    objBnProgramacionClaseIII.getPrecio(),
                    objBnProgramacionClaseIII.getCantidad(),
                    usuario,
                    modo
            );
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }
}
