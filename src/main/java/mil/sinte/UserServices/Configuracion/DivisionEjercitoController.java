package mil.sinte.UserServices.Configuracion;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.BusinessServices.Beans.BeanDivisionEjercito;
import mil.sinte.DataService.Service.DivisionEjercitoService;
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
public class DivisionEjercitoController {

    @Autowired
    private DivisionEjercitoService divisionEjercitoService;

    @RequestMapping(value = "/DivisionEjercito")
    public String getDivisionEjercito(String mode) {
        switch (mode) {
            case "divisionEjercito":
                return "Configuracion/DivisionEjercito";
            default:
                return "redirect:/";
        }
    }

    @RequestMapping(value = "/DivisionEjercitoDetalle")
    @ResponseBody
    public String getDivisionEjercitoDetalle(String mode, Integer codigo) {
        switch (mode) {
            case "G":
                return new Gson().toJson(divisionEjercitoService.getDivisionEjercito());
            case "U":
                return new Gson().toJson(divisionEjercitoService.getDivisionEjercito(codigo));
            default:
                return "ERROR";
        }
    }

    @RequestMapping(value = "/IduDivisionEjercito")
    @ResponseBody
    public String setDivisionEjercito(
            @RequestParam("mode") String mode,
            @RequestParam("codigo") Integer codigo,
            @RequestParam("abreviatura") String abreviatura,
            @RequestParam("descripcion") String descripcion) {
        BeanDivisionEjercito objBeanDivisionEjercito = new BeanDivisionEjercito();
        objBeanDivisionEjercito.setCodigo(codigo);
        objBeanDivisionEjercito.setDescripcion(descripcion);
        objBeanDivisionEjercito.setAbreviatura(abreviatura);
        return "" + divisionEjercitoService.guardarDivisionEjercito(objBeanDivisionEjercito, Utiles.getUsuario(), mode);
    }
}
