package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanCombos;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface CombosService {

    /*MODULO CONFIGURACION*/
    public List<BeanCombos> getPeriodos();

    public List<BeanCombos> getDivisionEjercito();

    public List<BeanCombos> getTipoCombustible();

    public List<BeanCombos> getDepartamentos();

    public List<BeanCombos> getProvincias(String departamento);

    public List<BeanCombos> getUbigeo(String departamento, String provincia);

    public List<BeanCombos> getTipoDependencia();

    public List<BeanCombos> getBrigadas();

    public List<BeanCombos> getBrigadasByUsuario(String usuario);

    /*MODULO PROGRAMACION*/
    public List<BeanCombos> getPeriodoTipoAsignacionPendiente(String periodo);

    public List<BeanCombos> getTipoAsignacionByPeriodo(String periodo);

    public List<BeanCombos> getBrigadasByPeriodoTipoAsignacion(String periodo, Integer TipoAsignacion);

}
