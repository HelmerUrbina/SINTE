package mil.sinte.UserServices.Configuracion;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.BusinessServices.Beans.BeanPeriodos;
import mil.sinte.DataService.Service.PeriodosService;
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
public class PeriodosController {

    @Autowired
    private PeriodosService periodosService;

    @RequestMapping(value = "/Periodos")
    public String getAreaLaboral(String mode) {
        switch (mode) {
            case "periodo":
                return "Configuracion/Periodos";
            default:
                return "redirect:/";
        }
    }

    @RequestMapping(value = "/PeriodosDetalle")
    @ResponseBody
    public String getAreaLaboralDetalle(String mode, String codigo) {
        switch (mode) {
            case "G":
                return new Gson().toJson(periodosService.getPeriodos());
            case "U":
                return new Gson().toJson(periodosService.getPeriodos(codigo));
            default:
                return "ERROR";
        }
    }

    @RequestMapping(value = "/IduPeriodos")
    @ResponseBody
    public String setAreaLaboral(
            @RequestParam("mode") String mode,
            @RequestParam("codigo") String codigo,
            @RequestParam("abreviatura") String abreviatura,
            @RequestParam("descripcion") String descripcion) {
        BeanPeriodos objBeanPeriodo = new BeanPeriodos();
        objBeanPeriodo.setCodigo(codigo);
        objBeanPeriodo.setDescripcion(descripcion);
        objBeanPeriodo.setAbreviatura(abreviatura);
        return "" + periodosService.guardarPeriodos(objBeanPeriodo, Utiles.getUsuario(), mode);
    }
}
