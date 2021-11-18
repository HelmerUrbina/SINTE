/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanVehiculosClase;
import mil.sinte.DataService.DAO.VehiculosClaseDAO;
import mil.sinte.DataService.Service.VehiculosClaseService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class VehiculosClaseServiceImpl implements VehiculosClaseService{
    
    @Autowired
    private VehiculosClaseDAO vehiculosClaseDAO;
    
    @Override
    public List<BeanVehiculosClase> getVehiculosClases() {
        return vehiculosClaseDAO.findAll();
    }

    @Override
    public BeanVehiculosClase getVehiculosClase(String codigo) {
        return vehiculosClaseDAO.findByCodigo(Integer.parseInt(codigo));
    }

    @Override
    public String guardarVehiculosClase(BeanVehiculosClase objBeanVehiculosClase, String usuario, String modo) {
        String result = "GUARDO";
        try {
            vehiculosClaseDAO.sp_vehiculo_clase(
                    Integer.parseInt(objBeanVehiculosClase.getCodigo()),
                    objBeanVehiculosClase.getDescripcion(),
                    objBeanVehiculosClase.getAbreviatura(),
                    usuario,
                    modo
            );
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;  
    }
    
}
