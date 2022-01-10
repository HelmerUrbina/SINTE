/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.UserServices.Configuracion;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.BusinessServices.Beans.BeanFirmaUsuario;
import mil.sinte.DataService.Service.FirmaUsuarioService;
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
public class FirmaUsuarioController {
    
    @Autowired
    private FirmaUsuarioService firmaUsuarioService;
    
    @RequestMapping(value = "/FirmaUsuario")
    public String getFirma(String mode) {
        switch (mode) {
            case "firmaUsuario":
                return "Configuracion/FirmaUsuario";
            default:
                return "redirect:/";
        }
    }
    
    @RequestMapping(value = "/firmasUsuarios")
    @ResponseBody
    public String getFirmasDetalle(String mode, String periodo) {
        switch (mode) {
            case "G":
                return new Gson().toJson(firmaUsuarioService.getFirmas(periodo));
            default:
                return "ERROR";
        }
    }
    
    @RequestMapping(value = "/IduFirma")
    @ResponseBody
    public String setFirma(
            @RequestParam("mode") String mode,
            @RequestParam("periodo") String periodo,
            @RequestParam("usuario") String usuario,
            @RequestParam("serie") String serie,
            @RequestParam("grado") String grado) {
        BeanFirmaUsuario obj = new BeanFirmaUsuario();
        obj.setPeriodo(periodo);
        obj.setUsuario(usuario);
        obj.setSerie(serie);
        obj.setGrado(grado);
        return "" + firmaUsuarioService.guardarFirma(obj, Utiles.getUsuario(), mode);
    }
    
}
