/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanVariacion;
import mil.sinte.DataService.DAO.VariacionDAO;
import mil.sinte.DataService.Service.VariacionService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class VariacionServiceImpl implements VariacionService{

    @Autowired
    private VariacionDAO variacionDAO;
    

    @Override
    public List<BeanVariacion> getVariaciones(String periodo, Integer brigada, String mes) {
        return variacionDAO.findAll(periodo, brigada, mes);
    }

    @Override
    public String guardarVariacion(BeanVariacion objBeanVariacion, String usuario, String modo) {
        String result = "GUARDO";
        try {
            variacionDAO.sp_variacion(
                    objBeanVariacion.getCodigo()!= null ? Integer.parseInt(objBeanVariacion.getCodigo()) : null,
                    objBeanVariacion.getCodigoPeriodo(),
                    objBeanVariacion.getCodigoBrigada()!=null?Integer.parseInt(objBeanVariacion.getCodigoBrigada()):null,
                    objBeanVariacion.getCodigoMes(),
                    objBeanVariacion.getCodigoAsignacion()!=null?Integer.parseInt(objBeanVariacion.getCodigoAsignacion()):null,
                    objBeanVariacion.getCodigoCombustible()!=null?Integer.parseInt(objBeanVariacion.getCodigoCombustible()):null,
                    objBeanVariacion.getFecha(),
                    objBeanVariacion.getJustificacion(),
                    objBeanVariacion.getRechazo(),
                    objBeanVariacion.getEstado(),
                    usuario,
                    modo
            );
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }

    
}
