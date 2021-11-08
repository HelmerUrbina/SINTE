package mil.sinte.DataService.Service;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanCombos;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface CombosService {

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
    
    public List<BeanCombos> getBrigada();
    
    public List<BeanCombos> getRol();

}
