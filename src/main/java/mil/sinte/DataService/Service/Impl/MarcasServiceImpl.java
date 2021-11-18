/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanMarcas;
import mil.sinte.DataService.DAO.MarcasDAO;
import mil.sinte.DataService.Service.MarcasService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class MarcasServiceImpl implements MarcasService{
    
    @Autowired
    private MarcasDAO marcasDAO;

    @Override
    public List<BeanMarcas> getMarcas() {
        return marcasDAO.findAll();
    }

    @Override
    public BeanMarcas getMarca(String codigo) {
        return marcasDAO.findByCodigo(Integer.parseInt(codigo));
    }

    @Override
    public String guardarMarcas(BeanMarcas objBeanMarcas, String usuario, String modo) {
        String result = "GUARDO";
        try {
            marcasDAO.sp_marcas(
                    Integer.parseInt(objBeanMarcas.getCodigo()),
                    objBeanMarcas.getDescripcion(),
                    usuario,
                    modo
            );
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;  
    }
    
    
    
}
