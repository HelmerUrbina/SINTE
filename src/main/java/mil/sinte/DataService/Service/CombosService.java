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

    public List<BeanCombos> getTipoVehiculo();

    public List<BeanCombos> getClaseVehiculo();

    public List<BeanCombos> getMarca();

    public List<BeanCombos> getModelo(String marca);

    public List<BeanCombos> getColor();

    public List<BeanCombos> getSoat();

    public List<BeanCombos> getAreaLaboral();

    public List<BeanCombos> getRol();

    public List<BeanCombos> getVehiculosByBrigadaAndPeriodo(String periodo, Integer brigada);

    public List<BeanCombos> getDependenciaByVehiAndBrigAndPeri(String periodo, String brigada, String vehiculo);

    public List<BeanCombos> getVehiculosByPeriodo(String periodo);

    public List<BeanCombos> getVehiculosByPeriodoBrigada(String periodo, Integer brigada);

    public List<BeanCombos> getDependenciaByBrigada(String brigada);

    public List<BeanCombos> getBrigadas();

    public List<BeanCombos> getBrigadasByUsuario(String usuario);

    public List<BeanCombos> getTipoCombustibleByVehiculo(Integer vehiculo);

    /*MODULO PROGRAMACION*/
    public List<BeanCombos> getPeriodoTipoAsignacionPendiente(String periodo);

    public List<BeanCombos> getTipoAsignacionByPeriodo(String periodo);

    public List<BeanCombos> getBrigadasByPeriodoTipoAsignacion(String periodo, Integer TipoAsignacion);

}
