/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.UserServices.Configuracion;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.BusinessServices.Beans.BeanMarcas;
import mil.sinte.BusinessServices.Beans.BeanSoatAseguradora;
import mil.sinte.DataService.Service.SoatAseguradoService;
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
public class SoatAseguradoraController {
    
    @Autowired
    private SoatAseguradoService soatAseguradoService;
    
    @RequestMapping(value = "/Aseguradora")
    public String getAseguradora(String mode) {
        switch (mode) {
            case "aseguradora":
                return "Configuracion/Aseguradora";
            default:
                return "redirect:/";
        }
    }
    
    @RequestMapping(value = "/AseguradoraDetalle")
    @ResponseBody
    public String getAseguradoraDetalle(String mode, String codigo) {
        switch (mode) {
            case "G":
                return new Gson().toJson(soatAseguradoService.getSoatAseguradoras());
            case "U":
                return new Gson().toJson(soatAseguradoService.getSoatAseguradora(codigo));
            default:
                return "ERROR";
        }
    }
    
    @RequestMapping(value = "/IduAseguradora")
    @ResponseBody
    public String setAseguradora(
            @RequestParam("mode") String mode,
            @RequestParam("codigo") String codigo,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("telefono") String telefono,
            @RequestParam("direccion") String direccion) {
        BeanSoatAseguradora objAseguradora = new BeanSoatAseguradora();
        objAseguradora.setCodigo(codigo);
        objAseguradora.setDescripcion(descripcion);
        objAseguradora.setTelefono(telefono);
        objAseguradora.setDireccion(direccion);
        
        return "" + soatAseguradoService.guardarSoatAseguradora(objAseguradora, Utiles.getUsuario(), mode);
    }
    
}
