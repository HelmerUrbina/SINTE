package mil.sinte.UserServices.Configuracion;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.BusinessServices.Beans.BeanVehiculoTipo;
import mil.sinte.DataService.Service.VehiculoTipoService;
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
public class VehiculoTipoController {

    @Autowired
    private VehiculoTipoService vehiculoTipoService;

    @RequestMapping(value = "/VehiculoTipo")
    public String getVehiculoTipo(String mode) {
        switch (mode) {
            case "vehiculoTipo":
                return "Configuracion/VehiculoTipo";
            default:
                return "redirect:/";
        }
    }

    @RequestMapping(value = "/VehiculoTipoDetalle")
    @ResponseBody
    public String getVehiculoTipoDetalle(String mode, String codigo) {
        switch (mode) {
            case "G":
                return new Gson().toJson(vehiculoTipoService.getVehiculoTipos());
            default:
                return "ERROR";
        }
    }

    @RequestMapping(value = "/IduVehiculoTipo")
    @ResponseBody
    public String setVehiculoTipo(
            @RequestParam("mode") String mode,
            @RequestParam("codigo") String codigo,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("abreviatura") String abreviatura) {
        BeanVehiculoTipo objBeanVehiculoTipo = new BeanVehiculoTipo();
        objBeanVehiculoTipo.setCodigo(codigo);
        objBeanVehiculoTipo.setDescripcion(descripcion);
        objBeanVehiculoTipo.setAbreviatura(abreviatura);
        return "" + vehiculoTipoService.guardarVehiculoTipo(objBeanVehiculoTipo, Utiles.getUsuario(), mode);
    }

}
