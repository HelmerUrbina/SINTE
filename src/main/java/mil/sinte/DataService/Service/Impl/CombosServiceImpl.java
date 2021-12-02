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

    @Override
    public List<BeanCombos> getTipoCombustibleByVehiculo(Integer vehiculo) {
        return combosDAO.getTipoCombustibleByVehiculo(vehiculo);
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

    @Override
    public List<BeanCombos> getTipoVehiculo() {
        return combosDAO.getTipoVehiculo();
    }

    @Override
    public List<BeanCombos> getClaseVehiculo() {
        return combosDAO.getClaseVehiculo();
    }

    @Override
    public List<BeanCombos> getMarca() {
        return combosDAO.getMarca();
    }

    @Override
    public List<BeanCombos> getModelo(String marca) {
        return combosDAO.getModelo(marca);
    }

    @Override
    public List<BeanCombos> getColor() {
        return combosDAO.getColor();
    }

    @Override
    public List<BeanCombos> getSoat() {
        return combosDAO.getSoat();
    }

    @Override
    public List<BeanCombos> getAreaLaboral() {
        return combosDAO.getAreaLaboral();
    }

    @Override
    public List<BeanCombos> getRol() {
        return combosDAO.getRol();
    }

    @Override
    public List<BeanCombos> getVehiculosByBrigadaAndPeriodo(String periodo, Integer brigada) {
        return combosDAO.getVehiculosByBrigadaAndPeriodo(periodo, brigada);
    }

    @Override
    public List<BeanCombos> getDependenciaByVehiAndBrigAndPeri(String periodo, String brigada, String vehiculo) {
        return combosDAO.getDependenciaByVehiAndBrigAndPeri(periodo, Integer.parseInt(brigada), Integer.parseInt(vehiculo)
        );
    }

    @Override
    public List<BeanCombos> getVehiculosByPeriodo(String periodo) {
        return combosDAO.getVehiculosByPeriodo(periodo);
    }

    @Override
    public List<BeanCombos> getVehiculosByPeriodoBrigada(String periodo, Integer brigada) {
        return combosDAO.getVehiculosByPeriodoAndBrigada(periodo, brigada);
    }

    @Override
    public List<BeanCombos> getDependenciaByBrigada(String brigada) {
        return combosDAO.getDependenciaByBrigada(Integer.parseInt(brigada));
    }

    @Override
    public List<BeanCombos> getMeses() {
        return combosDAO.getMeses();
    }

    @Override
    public List<BeanCombos> getTipoCombustibleByAsignacionCombustible(String anio, Integer brigada, String mes, Integer tipoAsignacion) {
        return combosDAO.getTipoCombustibleByAsignacionCombustible(anio, brigada, mes, tipoAsignacion);
    }

    @Override
    public List<BeanCombos> getVehiculoByAsignacionCombustible(String anio, Integer brigada, String mes, Integer tipoAsignacion, Integer tipoCombustible, Integer dependencia) {
        return combosDAO.getVehiculoByAsignacionCombustible(anio, brigada, mes, tipoAsignacion, tipoCombustible,dependencia);
    }

}
