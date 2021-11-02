package mil.sinte.UserServices.Configuracion;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.BusinessServices.Beans.BeanTipoDependencia;
import mil.sinte.DataService.Service.TipoDependenciaService;
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
public class TipoDependenciaController {

    @Autowired
    private TipoDependenciaService tipoDependenciaService;

    @RequestMapping(value = "/TipoDependencia")
    public String getTipoDependencia(String mode) {
        switch (mode) {
            case "tipoDependencia":
                return "Configuracion/TipoDependencia";
            default:
                return "redirect:/";
        }
    }

    @RequestMapping(value = "/TipoDependenciaDetalle")
    @ResponseBody
    public String getTipoDependenciaDetalle(String mode, Integer codigo) {
        switch (mode) {
            case "G":
                return new Gson().toJson(tipoDependenciaService.getTipoDependencia());
            case "U":
                return new Gson().toJson(tipoDependenciaService.getTipoDependencia(codigo));
            default:
                return "ERROR";
        }
    }

    @RequestMapping(value = "/IduTipoDependencia")
    @ResponseBody
    public String setTipoDependencia(
            @RequestParam("mode") String mode,
            @RequestParam("codigo") Integer codigo,
            @RequestParam("abreviatura") String abreviatura,
            @RequestParam("descripcion") String descripcion) {
        BeanTipoDependencia objBeanTipoDependencia = new BeanTipoDependencia();
        objBeanTipoDependencia.setCodigo(codigo);
        objBeanTipoDependencia.setDescripcion(descripcion);
        objBeanTipoDependencia.setAbreviatura(abreviatura);
        return "" + tipoDependenciaService.guardarTipoDependencia(objBeanTipoDependencia, Utiles.getUsuario(), mode);
    }
}
