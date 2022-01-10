/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanReporteUsuario;
import mil.sinte.DataService.DAO.ReporteUsuarioDAO;
import mil.sinte.DataService.Service.ReporteUsuarioService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class ReporteUsuarioServiceImpl implements  ReporteUsuarioService{
    
    @Autowired
    private ReporteUsuarioDAO reporteUsuarioDAO;

    @Override
    public List<BeanReporteUsuario> getReportesByusuarios(String periodo, String reporte) {
        return reporteUsuarioDAO.findAll(periodo, reporte);
    }

    @Override
    public String guardarReportes(BeanReporteUsuario obj, String usuario, String mode) {
        String result = "GUARDO";
        try {
            reporteUsuarioDAO.sp_reporte(
                    obj.getPeriodo(),
                    obj.getReporte(),
                    obj.getUsuario(),
                    Integer.parseInt(obj.getNivel()),
                    usuario,
                    mode
            );
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }
    
}
