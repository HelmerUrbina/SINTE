package mil.sinte.UserServices.Configuracion;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.BusinessServices.Beans.BeanTipoAsignacion;
import mil.sinte.DataService.Service.TipoAsignacionService;
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
public class TipoAsignacionlController {

    @Autowired
    private TipoAsignacionService tipoAsignacionService;

    @RequestMapping(value = "/TipoAsignacion")
    public String getTipoAsignacion(String mode) {
        switch (mode) {
            case "tipoAsignacion":
                return "Configuracion/TipoAsignacion";
            default:
                return "redirect:/";
        }
    }

    @RequestMapping(value = "/TipoAsignacionDetalle")
    @ResponseBody
    public String getTipoAsignacionDetalle(String mode, Integer codigo) {
        switch (mode) {
            case "G":
                return new Gson().toJson(tipoAsignacionService.getTipoAsignacion());
            case "U":
                return new Gson().toJson(tipoAsignacionService.getTipoAsignacion(codigo));
            default:
                return "ERROR";
        }
    }

    @RequestMapping(value = "/IduTipoAsignacion")
    @ResponseBody
    public String setTipoAsignacion(
            @RequestParam("mode") String mode,
            @RequestParam("codigo") Integer codigo,
            @RequestParam("abreviatura") String abreviatura,
            @RequestParam("descripcion") String descripcion) {
        BeanTipoAsignacion objBeanTipoAsignacion = new BeanTipoAsignacion();
        objBeanTipoAsignacion.setCodigo(codigo);
        objBeanTipoAsignacion.setDescripcion(descripcion);
        objBeanTipoAsignacion.setAbreviatura(abreviatura);
        return "" + tipoAsignacionService.guardarTipoAsignacion(objBeanTipoAsignacion, Utiles.getUsuario(), mode);
    }
}
