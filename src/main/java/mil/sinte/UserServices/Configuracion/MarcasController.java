/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.UserServices.Configuracion;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.BusinessServices.Beans.BeanBrigadas;
import mil.sinte.BusinessServices.Beans.BeanMarcas;
import mil.sinte.DataService.Service.MarcasService;
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
public class MarcasController {
    
    @Autowired
    private MarcasService marcasService;
    
    @RequestMapping(value = "/Marcas")
    public String getMarcas(String mode) {
        switch (mode) {
            case "marcas":
                return "Configuracion/Marcas";
            default:
                return "redirect:/";
        }
    }
    
    @RequestMapping(value = "/MarcasDetalle")
    @ResponseBody
    public String getMarcasDetalle(String mode, String codigo) {
        switch (mode) {
            case "G":
                return new Gson().toJson(marcasService.getMarcas());
            case "U":
                return new Gson().toJson(marcasService.getMarca(codigo));
            default:
                return "ERROR";
        }
    }
    
    @RequestMapping(value = "/IduMarcas")
    @ResponseBody
    public String setMarcas(
            @RequestParam("mode") String mode,
            @RequestParam("codigo") String codigo,
            @RequestParam("descripcion") String descripcion) {
        BeanMarcas objBeanMarcas = new BeanMarcas();
        objBeanMarcas.setCodigo(codigo);
        objBeanMarcas.setDescripcion(descripcion);
        
        return "" + marcasService.guardarMarcas(objBeanMarcas, Utiles.getUsuario(), mode);
    }
}
