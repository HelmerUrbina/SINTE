package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanModelos;
import mil.sinte.DataService.DAO.ModelosDAO;
import mil.sinte.DataService.Service.ModelosService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class ModelosServiceImpl implements ModelosService {

    @Autowired
    private ModelosDAO modelosDAO;

    @Override
    public List<BeanModelos> getModelos() {
        return modelosDAO.findAll();
    }

    @Override
    public BeanModelos getModelo(String modelo) {
        return modelosDAO.findByCodigo(modelo);
    }

    @Override
    public String guardarModelos(BeanModelos objBeanModelos, String usuario, String modo) {
        String result = "GUARDO";
        try {
            modelosDAO.sp_modelos(
                    Integer.parseInt(objBeanModelos.getModelo()),
                    Integer.parseInt(objBeanModelos.getMarca()),
                    objBeanModelos.getDescripcion(),
                    usuario,
                    modo
            );
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }

}
