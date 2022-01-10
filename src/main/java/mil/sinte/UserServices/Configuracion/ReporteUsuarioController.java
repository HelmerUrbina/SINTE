/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.UserServices.Configuracion;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.BusinessServices.Beans.BeanFirmaUsuario;
import mil.sinte.BusinessServices.Beans.BeanReporteUsuario;
import mil.sinte.DataService.Service.ReporteUsuarioService;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Controller
@Slf4j
public class ReporteUsuarioController {
    
    @Autowired
    private ReporteUsuarioService reporteUsuarioService;
    
    @RequestMapping(value = "/ReporteUsuario")
    public String getReporte(String mode) {
        switch (mode) {
            case "reporteUsuario":
                return "Configuracion/ReporteUsuario";
            default:
                return "redirect:/";
        }
    }
    
    @RequestMapping(value = "/reportesUsuarios")
    @ResponseBody
    public String getReportesDetalle(String mode, String periodo, String reporte) {
        switch (mode) {
            case "G":
                return new Gson().toJson(reporteUsuarioService.getReportesByusuarios(periodo, reporte));
            default:
                return "ERROR";
        }
    }
    
    @RequestMapping(value = "/IduReporte")
    @ResponseBody
    public String setReporte(
            @RequestParam("mode") String mode,
            @RequestParam("periodo") String periodo,
            @RequestParam("reporte") String reporte,
            @RequestParam("usuario") String usuario,
            @RequestParam("nivel") String nivel) {
        BeanReporteUsuario obj = new BeanReporteUsuario();
        obj.setPeriodo(periodo);
        obj.setReporte(reporte);
        obj.setUsuario(usuario);
        obj.setNivel(nivel);
        return "" + reporteUsuarioService.guardarReportes(obj, Utiles.getUsuario(), mode);
    }
    
    
}
