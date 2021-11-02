package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanTipoCombustible;
import mil.sinte.DataService.DAO.TipoCombustibleDAO;
import mil.sinte.DataService.Service.TipoCombustibleService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class TipoCombustibleServiceImpl implements TipoCombustibleService {

    @Autowired
    private TipoCombustibleDAO tipoCombustibleDAO;

    @Override
    public List<BeanTipoCombustible> getTipoCombustible() {
        return tipoCombustibleDAO.findAll();
    }

    @Override
    public BeanTipoCombustible getTipoCombustible(Integer codigo) {
        return tipoCombustibleDAO.findByCodigo(codigo);
    }

    @Override
    public String guardarTipoCombustible(BeanTipoCombustible objBnTipoCombustible, String usuario, String modo) {
        String result = "GUARDO";
        try {
            tipoCombustibleDAO.sp_tipoCombustible(
                    objBnTipoCombustible.getCodigo(),
                    objBnTipoCombustible.getDescripcion(),
                    objBnTipoCombustible.getAbreviatura(),
                    usuario,
                    modo);
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }

}
