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

    public List<BeanCombos> getBrigadas();

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

    public List<BeanCombos> getVehiculosByPeriodoAndBrigadas(String periodo, Integer brigada);

    public List<BeanCombos> getVehiculosByPeriodoAndBrigadasAndDependencia(String periodo, Integer brigada, Integer depedencia);

    public List<BeanCombos> getDependenciaByVehiAndBrigAndPeri(String periodo, String brigada, String vehiculo);

    public List<BeanCombos> getVehiculosByPeriodo(String periodo);

    public List<BeanCombos> getVehiculosByPeriodoBrigada(String periodo, Integer brigada);

    public List<BeanCombos> getDependenciaByBrigada(String brigada);

    public List<BeanCombos> getBrigadasByUsuario(String usuario);

    public List<BeanCombos> getTipoCombustibleByVehiculo(Integer vehiculo);

    /*MODULO PROGRAMACION*/
    public List<BeanCombos> getPeriodoTipoAsignacionPendiente(String periodo);

    public List<BeanCombos> getTipoAsignacionByPeriodo(String periodo);

    public List<BeanCombos> getBrigadasTechosByPeriodo(String periodo);

    public List<BeanCombos> getTipoAsignacionTechosByPeriodoAndBrigada(String periodo, Integer brigada);

    public List<BeanCombos> getTipoCombustibleTechosByPeriodoAndBrigadaAndTipoAsignacion(String periodo, Integer brigada, Integer tipoAsignacion);

    public List<BeanCombos> getDependenciasByPeriodoAndBrigadaAndTipoCombustible(String periodo, Integer brigada, Integer tipoCombustible);

    public List<BeanCombos> getVehiculosCNVByPeriodoAndBrigadaAndTipoCombustibleAndDependencia(String periodo, Integer brigada, Integer tipoCombustible, Integer Dependencia);

    public List<BeanCombos> getMeses();

    public List<BeanCombos> getTipoCombustibleByAsignacionCombustible(String anio, Integer brigada, String mes, Integer tipoAsignacion);

    public List<BeanCombos> getVehiculoByAsignacionCombustible(String anio, Integer brigada, String mes, Integer tipoAsignacion, Integer tipoCombustible, Integer dependencia);

    public List<BeanCombos> getCombsutibleByVariacion(String periodo, Integer brigada, String mes, Integer tipoAsignacion);

    public List<BeanCombos> getVehiculoByVariacion(String periodo, Integer brigada, String mes, Integer tipoAsignacion, Integer tipoCombustible, Integer dependencia);

    public List<BeanCombos> getDependenciaByVariacion(String periodo, Integer brigada, String mes, Integer tipoAsignacion, Integer tipoCombustible);

    public List<BeanCombos> getDependenciaByComision(String periodo, Integer brigada, String mes, Integer tipoAsignacion);

    public List<BeanCombos> getVehiculoByComision(String periodo, Integer brigada, String mes, Integer tipoAsignacion, Integer dependencia);

    public List<BeanCombos> getCombustibleByComision(String periodo, Integer brigada, String mes, Integer tipoAsignacion, Integer dependencia, Integer vehiculo);
}
