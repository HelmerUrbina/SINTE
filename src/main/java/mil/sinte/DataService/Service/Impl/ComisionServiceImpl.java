/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanComision;
import mil.sinte.DataService.DAO.ComisionDAO;
import mil.sinte.DataService.Service.ComisionService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class ComisionServiceImpl implements ComisionService{

    @Autowired
    private ComisionDAO comisionDAO;
    
    
    @Override
    public List<BeanComision> findAll(String periodo, Integer brigada, String mes, Integer asignacion) {
        return comisionDAO.findAll(periodo, brigada, mes, asignacion);
    }

    @Override
    public String guardarComision(BeanComision objBeanComision, String usuario, String modo) {
        String result = "GUARDO";
        try {
            comisionDAO.sp_comision(
                    objBeanComision.getCodigo()!= null ? Integer.parseInt(objBeanComision.getCodigo()) : null,
                    objBeanComision.getCodigoPeriodo(),
                    objBeanComision.getCodigoBrigada()!=null?Integer.parseInt(objBeanComision.getCodigoBrigada()):null,
                    objBeanComision.getCodigoMes(),
                    objBeanComision.getCodigoAsignacion()!=null?Integer.parseInt(objBeanComision.getCodigoAsignacion()):null,
                    objBeanComision.getDescripcion(),
                    objBeanComision.getEstado(),
                    usuario,
                    modo
            );
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;   
    }
    
}
