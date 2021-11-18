/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.sinte.UserServices.Seguriidad;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.BusinessServices.Beans.BeanUsuario;
import mil.sinte.BusinessServices.Beans.BeanVehiculoSoat;
import mil.sinte.DataService.Service.UsuarioMenuService;
import mil.sinte.DataService.Service.UsuarioService;
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
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private UsuarioMenuService usuarioMenuService;
    
    @RequestMapping(value = "/Usuarios")
    public String getUsuario(String mode) {
        switch (mode) {
            case "usuario":
                return "seguridad/Usuario";
            default:
                return "redirect:/";
        }
    }
    
    @RequestMapping(value = "/UsuariosDetalle")
    @ResponseBody
    public String getUsuarioDetalle(String mode, String codigo) {
        switch (mode) {
            case "G":
                return new Gson().toJson(usuarioService.findAll());
            case "U":
                return new Gson().toJson(usuarioService.findByCodigo(codigo));
            case "M":
                return new Gson().toJson(usuarioMenuService.getOpcionesUsuario());
            case "MU":
                return new Gson().toJson(usuarioMenuService.getOpcionesOfUsuario(codigo));    
            default:
                return "ERROR";
        }
    }
    
    @RequestMapping(value = "/IduUsuarios")
    @ResponseBody
    public String setUsuario(
            @RequestParam("mode") String mode,
            @RequestParam("codigo") String codigo,
            @RequestParam("areaLaboral") String areaLaboral,
            @RequestParam("rol") String rol,
            @RequestParam("brigada") String brigada,
            @RequestParam("paterno") String paterno,
            @RequestParam("materno") String materno,
            @RequestParam("nombres") String nombres,
            @RequestParam("correo") String correo,
            @RequestParam("telf") String telf,
            @RequestParam("cargo") String cargo,
            @RequestParam("auto") Integer auto,
            @RequestParam("lista") String lista
            ) {
        BeanUsuario objBeanUsuario = new BeanUsuario();
        objBeanUsuario.setUsuario(codigo);
        objBeanUsuario.setAreaLaboral(areaLaboral);
        objBeanUsuario.setRol(rol);
        objBeanUsuario.setBrigada(brigada);
        objBeanUsuario.setPaterno(paterno);
        objBeanUsuario.setMaterno(materno);
        objBeanUsuario.setNombres(nombres);
        objBeanUsuario.setCorreo(correo);
        objBeanUsuario.setTelefono(telf);
        objBeanUsuario.setCargo(cargo);
        objBeanUsuario.setAutorizacion(auto);
        return "" + usuarioService.guardarUsuario(objBeanUsuario, lista, Utiles.getUsuario(), mode);
    }
}
