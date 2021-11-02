package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanTipoDependencia;
import mil.sinte.DataService.DAO.TipoDependenciaDAO;
import mil.sinte.DataService.Service.TipoDependenciaService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class TipoDependenciaServiceImpl implements TipoDependenciaService {

    @Autowired
    private TipoDependenciaDAO tipoDependenciaDAO;

    @Override
    public List<BeanTipoDependencia> getTipoDependencia() {
        return tipoDependenciaDAO.findAll();
    }

    @Override
    public BeanTipoDependencia getTipoDependencia(Integer codigo) {
        return tipoDependenciaDAO.findByCodigo(codigo);
    }

    @Override
    public String guardarTipoDependencia(BeanTipoDependencia objBnTipoDependencia, String usuario, String modo) {
        String result = "GUARDO";
        try {
            tipoDependenciaDAO.sp_tipoDependencia(
                    objBnTipoDependencia.getCodigo(),
                    objBnTipoDependencia.getDescripcion(),
                    objBnTipoDependencia.getAbreviatura(),
                    usuario,
                    modo);
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }
}
