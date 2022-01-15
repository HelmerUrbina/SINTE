package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanFuenteFinanciamiento;
import mil.sinte.DataService.DAO.FuenteFinanciamientoDAO;
import mil.sinte.DataService.Service.FuenteFinanciamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class FuenteFinanciamientoServiceImpl implements FuenteFinanciamientoService {

    @Autowired
    private FuenteFinanciamientoDAO fuenteFinanciamientoDAO;

    @Override
    public List<BeanFuenteFinanciamiento> getFuenteFinanciamiento() {
        return fuenteFinanciamientoDAO.findAll();
    }

}
