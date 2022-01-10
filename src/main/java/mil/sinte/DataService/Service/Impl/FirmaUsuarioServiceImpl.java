/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanFirmaUsuario;
import mil.sinte.DataService.DAO.FirmaUsuarioDAO;
import mil.sinte.DataService.Service.FirmaUsuarioService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class FirmaUsuarioServiceImpl implements FirmaUsuarioService{
    
    @Autowired
    private FirmaUsuarioDAO firmaUsuarioDAO;

    @Override
    public List<BeanFirmaUsuario> getFirmas(String periodo) {
        return firmaUsuarioDAO.findAll(periodo);
    }

    @Override
    public String guardarFirma(BeanFirmaUsuario obj, String usuario, String modo) {
        String result = "GUARDO";
        try {
            firmaUsuarioDAO.sp_firma(
                    obj.getPeriodo(),
                    obj.getUsuario(),
                    obj.getSerie(),
                    Integer.parseInt(obj.getGrado()),
                    usuario,
                    modo
            );
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }
    
}
