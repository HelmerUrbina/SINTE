package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanGrifoDespacho;
import mil.sinte.DataService.DAO.GrifoDespachoDAO;
import mil.sinte.DataService.Service.GrifoDespachoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class GrifoDespachoServiceImpl implements GrifoDespachoService {

    @Autowired
    private GrifoDespachoDAO grifoDespachoDAO;

    @Override
    public List<BeanGrifoDespacho> getDespachoByPlaca(String placa) {
        return grifoDespachoDAO.findByPlaca(placa);
    }
}
