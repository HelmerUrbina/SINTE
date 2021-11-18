/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.UserServices.Configuracion;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.BusinessServices.Beans.BeanColores;
import mil.sinte.DataService.Service.ColoresService;
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
public class ColoresController {

    @Autowired
    private ColoresService coloresService;

    @RequestMapping(value = "/Colores")
    public String getColores(String mode) {
        switch (mode) {
            case "colores":
                return "Configuracion/Colores";
            default:
                return "redirect:/";
        }
    }

    @RequestMapping(value = "/ColoresDetalle")
    @ResponseBody
    public String getColoresDetalle(String mode, String codigo) {
        switch (mode) {
            case "G":
                return new Gson().toJson(coloresService.getColores());
            case "U":
                return new Gson().toJson(coloresService.getColor(codigo));
            default:
                return "ERROR";
        }
    }

    @RequestMapping(value = "/IduColores")
    @ResponseBody
    public String setColores(
            @RequestParam("mode") String mode,
            @RequestParam("codigo") String codigo,
            @RequestParam("descripcion") String descripcion) {
        BeanColores objBeanColores = new BeanColores();
        objBeanColores.setCodigo(codigo);
        objBeanColores.setDescripcion(descripcion);
        return "" + coloresService.guardarColores(objBeanColores, Utiles.getUsuario(), mode);
    }

}
