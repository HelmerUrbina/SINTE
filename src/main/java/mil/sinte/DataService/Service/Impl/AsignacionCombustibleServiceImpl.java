/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.DataService.Service.Impl;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanAsignacionCombustible;
import mil.sinte.BusinessServices.Beans.BeanMatrizAsignacion;
import mil.sinte.DataService.DAO.AsignacionCombustibleDAO;
import mil.sinte.DataService.Service.AsignacionCombustibleService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mil.sinte.DataService.DAO.MatrizAsignacionDAO;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class AsignacionCombustibleServiceImpl implements AsignacionCombustibleService{
    
    @Autowired
    private AsignacionCombustibleDAO asignacionCombustibleDAO;
    @Autowired
    private MatrizAsignacionDAO matrizAsignacionDAO;

    @Override
    public List<BeanAsignacionCombustible> getAsignacionCombustibles(String periodo, String brigada, String mes, String tipoAsignacion) {
        return asignacionCombustibleDAO.findAll(periodo, Integer.parseInt(brigada), mes, Integer.parseInt(tipoAsignacion));
    }
    
    @Override
    public List<BeanMatrizAsignacion> getMatrizAsignacion(String periodo, String mes, String tipoAsignacion) {
        return matrizAsignacionDAO.findMatriz(periodo, mes, Integer.parseInt(tipoAsignacion));
    }

    @Override
    public String guardarAsignacionCombustible(BeanAsignacionCombustible objAsignacionCombustible, String usuario, String modo) {
        String result = "GUARDO";
        try {
            asignacionCombustibleDAO.sp_asignacion_combustible(
                    objAsignacionCombustible.getPeriodo(),
                    Integer.parseInt(objAsignacionCombustible.getBrigada()),
                    objAsignacionCombustible.getMes(),
                    Integer.parseInt(objAsignacionCombustible.getTipoAsignacion()),
                    Integer.parseInt(objAsignacionCombustible.getTipoCombustible()),
                    usuario,
                    modo
            );
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }

    @Override
    public String guardarAsignacionCombustibleAprobacion(BeanAsignacionCombustible objAsignacionCombustible, String usuario, String modo) {
        String result = "GUARDO";
        try {
            asignacionCombustibleDAO.sp_asignacion_combustible_Aprobacion(
                    objAsignacionCombustible.getPeriodo(),
                    Integer.parseInt(objAsignacionCombustible.getBrigada()),
                    objAsignacionCombustible.getMes(),
                    Integer.parseInt(objAsignacionCombustible.getTipoAsignacion()),
                    objAsignacionCombustible.getEstado(),
                    usuario,
                    modo
            );
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }

    @Override
    public String guardarAsignacionCombustibleAprobacion2(BeanAsignacionCombustible objAsignacionCombustible, String usuario, String modo) {
        String result = "GUARDO";
        try {
            asignacionCombustibleDAO.sp_asignacion_combustible_Aprobacion2(
                    objAsignacionCombustible.getPeriodo(),
                    objAsignacionCombustible.getMes(),
                    Integer.parseInt(objAsignacionCombustible.getTipoAsignacion()),
                    objAsignacionCombustible.getEstado(),
                    usuario,
                    modo
            );
        } catch (Exception | Error e) {
            result = Utiles.getErrorSQL((Exception) e);
        }
        return result;
    }

    
    
}
