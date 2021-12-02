/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanAsignacionCombustibleD;
import mil.sinte.DataService.DAO.AsignacionCombustibleDDAO;
import mil.sinte.DataService.Service.AsignacionCombustibleDService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class AsignacionCombustibleDServiceImpl implements AsignacionCombustibleDService{
    
    @Autowired
    private AsignacionCombustibleDDAO asignacionCombustibleDDAO;
    
    @Override
    public List<BeanAsignacionCombustibleD> getAsignacionCombustibleDs(String periodo, String brigada, String mes, String tipoAsignacion, String tipoCombustible) {
        return asignacionCombustibleDDAO.findAll(periodo, Integer.parseInt(brigada), mes, Integer.parseInt(tipoAsignacion), Integer.parseInt(tipoCombustible));
    }
    
    @Override
    public List<BeanAsignacionCombustibleD> getAsignacionCombustibleA(String periodo, String brigada, String mes, String tipoAsignacion, String tipoCombustible) {
        return asignacionCombustibleDDAO.findAllAprobacion(periodo, Integer.parseInt(brigada), mes, Integer.parseInt(tipoAsignacion), Integer.parseInt(tipoCombustible));
    }

    @Override
    public String guardarAsignacionCombustibleD(BeanAsignacionCombustibleD objAsignacionCombustibleD, String usuario, String modo) {
        String result = "GUARDO";
        try {
            asignacionCombustibleDDAO.sp_asignacion_combustible_d(
                    objAsignacionCombustibleD.getPeriodo(),
                    Integer.parseInt(objAsignacionCombustibleD.getBrigada()),
                    objAsignacionCombustibleD.getMes(),
                    Integer.parseInt(objAsignacionCombustibleD.getTipoAsignacion()),
                    Integer.parseInt(objAsignacionCombustibleD.getTipoCombustible()),
                    Integer.parseInt(objAsignacionCombustibleD.getDependencia()),
                    Integer.parseInt(objAsignacionCombustibleD.getVehiculo()),
                    objAsignacionCombustibleD.getCantidad(),
                    objAsignacionCombustibleD.getSolicitado(),
                    usuario,
                    modo
            );
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;   
    }

    @Override
    public String guardarAsignacionCombustibleA(BeanAsignacionCombustibleD objAsignacionCombustibleD, String usuario, String modo) {
        String result = "GUARDO";
        try {
            asignacionCombustibleDDAO.sp_asignacion_combustible_a(
                    objAsignacionCombustibleD.getPeriodo(),
                    Integer.parseInt(objAsignacionCombustibleD.getBrigada()),
                    objAsignacionCombustibleD.getMes(),
                    Integer.parseInt(objAsignacionCombustibleD.getTipoAsignacion()),
                    Integer.parseInt(objAsignacionCombustibleD.getTipoCombustible()),
                    objAsignacionCombustibleD.getVehiculo(),
                    usuario,
                    modo
            );
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }
    
}
