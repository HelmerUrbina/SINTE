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
import mil.sinte.BusinessServices.Beans.BeanComision;
import mil.sinte.BusinessServices.Beans.BeanVariacion;
import mil.sinte.DataService.Service.ComisionDetService;
import mil.sinte.DataService.Service.ComisionService;
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
public class AsignacionComisionController {
    
    @Autowired
    private ComisionService comisionService;
    
    @Autowired
    private ComisionDetService comisionDetService;
    
    @RequestMapping(value = "/AsignacionComision")
    public String getAsignacionComision(String mode) {
        switch (mode) {
            case "asignacionComision":
                return "ClaseIII/AsignacionComision";
            default:
                return "redirect:/";
        }
    }
    
    @RequestMapping(value = "/ComisionDetalle")
    @ResponseBody
    public String getComisionDetalle(String mode, String periodo, String brigada, String mes, String asignacion) {
        switch (mode) {
            case "G":
                return new Gson().toJson(comisionService.findAll(periodo, Integer.parseInt(brigada), mes, Integer.parseInt(asignacion)));
            default:
                return "ERROR";
        }
    }
    
    @RequestMapping(value = "/ComisionDetDetalle")
    @ResponseBody
    public String getComisionDetDetalle(String mode, String codigo) {
        switch (mode) {
            case "G":
                return new Gson().toJson(comisionDetService.findAll(Integer.parseInt(codigo)));
            default:
                return "ERROR";
        }
    }
    
    @RequestMapping(value = "/IduComision")
    @ResponseBody
    public String setComision(
            @RequestParam("mode") String mode,
            @RequestParam("codigo") String codigo,
            @RequestParam("periodo") String periodo,
            @RequestParam("brigada") String brigada,
            @RequestParam("mes") String mes,
            @RequestParam("asignacion") String asignacion,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("lista") String lista
    ) throws ParseException {
        BeanComision obj = new BeanComision();
        obj.setCodigo(codigo);
        obj.setCodigoPeriodo(periodo);
        obj.setCodigoBrigada(brigada);
        obj.setCodigoMes(mes);
        obj.setCodigoAsignacion(asignacion);
        obj.setDescripcion(descripcion);
        obj.setEstado(lista);
        
        return "" + comisionService.guardarComision(obj, Utiles.getUsuario(), mode);
    }
    
    
    
}
