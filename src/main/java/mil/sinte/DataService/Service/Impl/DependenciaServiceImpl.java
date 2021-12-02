package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanDependencia;
import mil.sinte.DataService.DAO.DependenciaDAO;
import mil.sinte.DataService.Service.DependenciaService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class DependenciaServiceImpl implements DependenciaService {

    @Autowired
    private DependenciaDAO dependenciaDAO;

    @Override
    public List<BeanDependencia> getDependencias(Integer brigada) {
        return dependenciaDAO.findByBrigada(brigada);
    }

    @Override
    public BeanDependencia getDependencia(Integer brigada, Integer codigo) {
        return dependenciaDAO.findByBrigadaAndCodigo(brigada, codigo);
    }

    @Override
    public String guardarDependencia(BeanDependencia objBnDependencia, String usuario, String modo) {
        String result = "GUARDO";
        try {
            dependenciaDAO.sp_dependencia(
                    objBnDependencia.getCodigo(),
                    objBnDependencia.getBrigada(),
                    objBnDependencia.getTipoDependencia(),
                    objBnDependencia.getDescripcion(),
                    objBnDependencia.getAbreviatura(),
                    usuario,
                    modo
            );
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }

}
