package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanCombos;
import mil.sinte.DataService.DAO.CombosDAO;
import mil.sinte.DataService.Service.CombosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class CombosServiceImpl implements CombosService {

    @Autowired
    private CombosDAO combosDAO;

    /*MODULO CONFIGURACION*/
    @Override
    public List<BeanCombos> getPeriodos() {
        return combosDAO.getPeriodos();
    }

    @Override
    public List<BeanCombos> getDivisionEjercito() {
        return combosDAO.getDivisionEjercito();
    }

    @Override
    public List<BeanCombos> getTipoCombustible() {
        return combosDAO.getTipoCombustible();
    }

    @Override
    public List<BeanCombos> getDepartamentos() {
        return combosDAO.getDepartamentos();
    }

    @Override
    public List<BeanCombos> getProvincias(String departamento) {
        return combosDAO.getProvincias(departamento);
    }

    @Override
    public List<BeanCombos> getUbigeo(String departamento, String provincia) {
        return combosDAO.getUbigeo(departamento, provincia);
    }

    @Override
    public List<BeanCombos> getTipoDependencia() {
        return combosDAO.getTipoDependencia();
    }

    @Override
    public List<BeanCombos> getBrigadas() {
        return combosDAO.getBrigadas();
    }

    @Override
    public List<BeanCombos> getBrigadasByUsuario(String usuario) {
        return combosDAO.getBrigadasByUsuario(usuario);
    }

    /*MODULO PROGRAMACION*/
    @Override
    public List<BeanCombos> getPeriodoTipoAsignacionPendiente(String periodo) {
        return combosDAO.getPeriodoTipoAsignacionPendiente(periodo);
    }

    @Override
    public List<BeanCombos> getTipoAsignacionByPeriodo(String periodo) {
        return combosDAO.getTipoAsignacionByPeriodo(periodo);
    }

    @Override
    public List<BeanCombos> getBrigadasByPeriodoTipoAsignacion(String periodo, Integer tipoAsignacion) {
        return combosDAO.getBrigadasByPeriodoTipoAsignacion(periodo, tipoAsignacion);
    }

}
