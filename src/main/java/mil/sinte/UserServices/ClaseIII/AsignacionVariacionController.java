/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.UserServices.ClaseIII;

import com.google.gson.Gson;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.BusinessServices.Beans.BeanVariacion;
import mil.sinte.DataService.Service.VariacionDetService;
import mil.sinte.DataService.Service.VariacionService;
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
public class AsignacionVariacionController {
    
    @Autowired
    private VariacionService variacionService;
    
    @Autowired
    private VariacionDetService variacionDetService;
    
    @RequestMapping(value = "/AsignacionVariacion")
    public String getAsignacionVariacion(String mode) {
        switch (mode) {
            case "asignacionVariacion":
                return "ClaseIII/AsignacionVariacion";
            default:
                return "redirect:/";
        }
    }
    
    @RequestMapping(value = "/VariacionDetalle")
    @ResponseBody
    public String getVariacionDetalle(String mode, String periodo, String brigada, String mes) {
        switch (mode) {
            case "G":
                return new Gson().toJson(variacionService.getVariaciones(periodo, Integer.parseInt(brigada), mes));
            default:
                return "ERROR";
        }
    }

    @RequestMapping(value = "/IduVariacion")
    @ResponseBody
    public String setVariacion(
            @RequestParam("mode") String mode,
            @RequestParam("codigo") String codigo,
            @RequestParam("periodo") String periodo,
            @RequestParam("brigada") String brigada,
            @RequestParam("mes") String mes,
            @RequestParam("asignacion") String asignacion,
            @RequestParam("combustible") String combustible,
            @RequestParam("fecha") String fecha,
            @RequestParam("justificacion") String justificacion,
            @RequestParam("rechazo") String rechazo,
            @RequestParam("lista") String lista
    ) throws ParseException {
        BeanVariacion obj = new BeanVariacion();
        obj.setCodigo(codigo);
        obj.setCodigoPeriodo(periodo);
        obj.setCodigoBrigada(brigada);
        obj.setCodigoMes(mes);
        obj.setCodigoAsignacion(asignacion);
        obj.setCodigoCombustible(combustible);
        obj.setJustificacion(justificacion);
        obj.setRechazo(rechazo);
        obj.setEstado(lista);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); //No Complaciente en Fecha
        java.util.Date fechaInicio = sdf.parse(Utiles.checkFecha(fecha));
        obj.setFecha(new java.sql.Date(fechaInicio.getTime()));
        
        return "" + variacionService.guardarVariacion(obj, Utiles.getUsuario(), mode);
    }
    
    @RequestMapping(value = "/VariacionDetDetalle")
    @ResponseBody
    public String getVariacionDetDetalle(String mode, String codigo) {
        switch (mode) {
            case "G":
                return new Gson().toJson(variacionDetService.getBeanVariacionDets(Integer.parseInt(codigo)));
            default:
                return "ERROR";
        }
    }
    
}
