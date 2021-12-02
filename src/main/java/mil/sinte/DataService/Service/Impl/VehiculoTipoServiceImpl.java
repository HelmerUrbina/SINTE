/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanVehiculoTipo;
import mil.sinte.DataService.DAO.VehiculoTipoDAO;
import mil.sinte.DataService.Service.VehiculoTipoService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class VehiculoTipoServiceImpl implements VehiculoTipoService {

    @Autowired
    private VehiculoTipoDAO VehiculoTipoDAO;

    @Override
    public List<BeanVehiculoTipo> getVehiculoTipos() {
        return VehiculoTipoDAO.findAll();
    }

    @Override
    public String guardarVehiculoTipo(BeanVehiculoTipo objBeanVehiculoTipo, String usuario, String modo) {
        String result = "GUARDO";
        try {
            VehiculoTipoDAO.sp_vehiculo_tipo(
                    Integer.parseInt(objBeanVehiculoTipo.getCodigo()),
                    objBeanVehiculoTipo.getDescripcion(),
                    objBeanVehiculoTipo.getAbreviatura(),
                    usuario,
                    modo
            );
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }

}
