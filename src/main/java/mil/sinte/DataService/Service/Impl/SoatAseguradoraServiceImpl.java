package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanSoatAseguradora;
import mil.sinte.DataService.DAO.SoatAseguradoraDAO;
import mil.sinte.DataService.Service.SoatAseguradoService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class SoatAseguradoraServiceImpl implements SoatAseguradoService {

    @Autowired
    private SoatAseguradoraDAO soatAseguradoraDAO;

    @Override
    public List<BeanSoatAseguradora> getSoatAseguradoras() {
        return soatAseguradoraDAO.findAll();
    }

    @Override
    public BeanSoatAseguradora getSoatAseguradora(String codigo) {
        return soatAseguradoraDAO.findByCodigo(Integer.parseInt(codigo));
    }

    @Override
    public String guardarSoatAseguradora(BeanSoatAseguradora objAseguradora, String usuario, String modo) {
        String result = "GUARDO";
        try {
            soatAseguradoraDAO.sp_soat_aseguradora(
                    Integer.parseInt(objAseguradora.getCodigo()),
                    objAseguradora.getDescripcion(),
                    objAseguradora.getTelefono(),
                    objAseguradora.getDireccion(),
                    usuario,
                    modo
            );
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }

}
