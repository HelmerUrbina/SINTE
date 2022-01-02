package mil.sinte.DataService.Service;

import mil.sinte.BusinessServices.Beans.BeanCombos;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public interface TextoService {

    public BeanCombos getPrecioTechosByPeriodoAndBrigadaAndTipoAsignacionAndTipoCombustible(String periodo, Integer brigada, Integer tipoAsignacion, Integer tipoCombustible);
    
    public BeanCombos getSaldoTechosByPeriodoAndBrigadaAndTipoAsignacionAndTipoCombustible(String periodo, Integer brigada, Integer tipoAsignacion, Integer tipoCombustible);

}
