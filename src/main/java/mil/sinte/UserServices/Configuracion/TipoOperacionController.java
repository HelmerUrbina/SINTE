package mil.sinte.UserServices.Configuracion;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.BusinessServices.Beans.BeanTipoOperacion;
import mil.sinte.DataService.Service.TipoOperacionService;
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
public class TipoOperacionController {

    @Autowired
    private TipoOperacionService tipoOperacionService;

    @RequestMapping(value = "/TipoOperacion")
    public String getTipoOperacion(String mode) {
        switch (mode) {
            case "tipoOperacion":
                return "Configuracion/TipoOperacion";
            default:
                return "redirect:/";
        }
    }

    @RequestMapping(value = "/TipoOperacionDetalle")
    @ResponseBody
    public String getTipoOperacionDetalle(String mode, Integer codigo) {
        switch (mode) {
            case "G":
                return new Gson().toJson(tipoOperacionService.getTipoOperacion());
            default:
                return "ERROR";
        }
    }

    @RequestMapping(value = "/IduTipoOperacion")
    @ResponseBody
    public String setTipoOperacion(
            @RequestParam("mode") String mode,
            @RequestParam("codigo") Integer codigo,
            @RequestParam("abreviatura") String abreviatura,
            @RequestParam("descripcion") String descripcion) {
        BeanTipoOperacion objBeanTipoOperacion = new BeanTipoOperacion();
        objBeanTipoOperacion.setCodigo(codigo);
        objBeanTipoOperacion.setDescripcion(descripcion);
        objBeanTipoOperacion.setAbreviatura(abreviatura);
        return "" + tipoOperacionService.guardarTipoOperacion(objBeanTipoOperacion, Utiles.getUsuario(), mode);
    }

}
