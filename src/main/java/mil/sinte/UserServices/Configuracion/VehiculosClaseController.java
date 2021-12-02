package mil.sinte.UserServices.Configuracion;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.BusinessServices.Beans.BeanVehiculosClase;
import mil.sinte.DataService.Service.VehiculosClaseService;
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
public class VehiculosClaseController {

    @Autowired
    private VehiculosClaseService vehiculosClaseService;

    @RequestMapping(value = "/VehiculosClase")
    public String getVehiculosClase(String mode) {
        switch (mode) {
            case "vehiculosClase":
                return "Configuracion/VehiculosClase";
            default:
                return "redirect:/";
        }
    }

    @RequestMapping(value = "/VehiculosClaseDetalle")
    @ResponseBody
    public String getVehiculosClaseDetalle(String mode, String codigo) {
        switch (mode) {
            case "G":
                return new Gson().toJson(vehiculosClaseService.getVehiculosClases());
            default:
                return "ERROR";
        }
    }

    @RequestMapping(value = "/IduVehiculosClase")
    @ResponseBody
    public String setVehiculosClase(
            @RequestParam("mode") String mode,
            @RequestParam("codigo") String codigo,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("abreviatura") String abreviatura) {
        BeanVehiculosClase objBeanVehiculosClase = new BeanVehiculosClase();
        objBeanVehiculosClase.setCodigo(codigo);
        objBeanVehiculosClase.setDescripcion(descripcion);
        objBeanVehiculosClase.setAbreviatura(abreviatura);
        return "" + vehiculosClaseService.guardarVehiculosClase(objBeanVehiculosClase, Utiles.getUsuario(), mode);
    }

}
