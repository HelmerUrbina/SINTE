/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.UserServices.Configuracion;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.BusinessServices.Beans.BeanModelos;
import mil.sinte.DataService.Service.ModelosService;
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
public class ModelosController {

    @Autowired
    private ModelosService modelosService;

    @RequestMapping(value = "/Modelos")
    public String getModelos(String mode) {
        switch (mode) {
            case "modelos":
                return "Configuracion/Modelos";
            default:
                return "redirect:/";
        }
    }

    @RequestMapping(value = "/ModelosDetalle")
    @ResponseBody
    public String getModelosDetalle(String mode, String codigo) {
        switch (mode) {
            case "G":
                return new Gson().toJson(modelosService.getModelos());
            case "U":
                return new Gson().toJson(modelosService.getModelo(codigo));
            default:
                return "ERROR";
        }
    }

    @RequestMapping(value = "/IduModelos")
    @ResponseBody
    public String setModelos(
            @RequestParam("mode") String mode,
            @RequestParam("modelo") String modelo,
            @RequestParam("marca") String marca,
            @RequestParam("descripcion") String descripcion) {
        BeanModelos objBeanModelos = new BeanModelos();
        objBeanModelos.setModelo(modelo);
        objBeanModelos.setMarca(marca);
        objBeanModelos.setDescripcion(descripcion);
        return "" + modelosService.guardarModelos(objBeanModelos, Utiles.getUsuario(), mode);
    }
}
