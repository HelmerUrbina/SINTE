/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanUsuarioGrifo;
import mil.sinte.DataService.DAO.UsuarioGrifoDAO;
import mil.sinte.DataService.Service.UsuarioGrifoService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class UsuarioGrifoServiceImpl implements UsuarioGrifoService{
   
    @Autowired
    private UsuarioGrifoDAO usuarioGrifoDAO;

    @Override
    public List<BeanUsuarioGrifo> getUsuario(Integer grifo, String periodo) {
        return usuarioGrifoDAO.findAll(grifo, periodo);
    }

    @Override
    public String guardarUsuarioGrifo(BeanUsuarioGrifo obj, String usuario, String modo) {
        String result = "GUARDO";
        try {
            usuarioGrifoDAO.sp_usuario_grifo(
                    obj.getUsuario(),
                    Integer.parseInt(obj.getGrifo()),
                    obj.getPeriodo(),
                    usuario,
                    modo
            );
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }
    
}
