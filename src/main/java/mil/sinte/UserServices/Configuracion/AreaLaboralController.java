package mil.sinte.UserServices.Configuracion;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.BusinessServices.Beans.BeanAreaLaboral;
import mil.sinte.DataService.Service.AreaLaboralService;
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
public class AreaLaboralController {

    @Autowired
    private AreaLaboralService areaLaboralService;

    @RequestMapping(value = "/AreaLaboral")
    public String getAreaLaboral(String mode) {
        switch (mode) {
            case "areaLaboral":
                return "Configuracion/AreaLaboral";
            default:
                return "redirect:/";
        }
    }

    @RequestMapping(value = "/AreaLaboralDetalle")
    @ResponseBody
    public String getAreaLaboralDetalle(String mode, Integer codigo) {
        switch (mode) {
            case "G":
                return new Gson().toJson(areaLaboralService.getAreaLaboral());
            case "U":
                return new Gson().toJson(areaLaboralService.getAreaLaboral(codigo));
            default:
                return "ERROR";
        }
    }

    @RequestMapping(value = "/IduAreaLaboral")
    @ResponseBody
    public String setAreaLaboral(
            @RequestParam("mode") String mode,
            @RequestParam("codigo") Integer codigo,
            @RequestParam("abreviatura") String abreviatura,
            @RequestParam("descripcion") String descripcion) {
        BeanAreaLaboral objBeanAreaLaboral = new BeanAreaLaboral();
        objBeanAreaLaboral.setCodigo(codigo);
        objBeanAreaLaboral.setDescripcion(descripcion);
        objBeanAreaLaboral.setAbreviatura(abreviatura);
        return "" + areaLaboralService.guardarAreaLaboral(objBeanAreaLaboral, Utiles.getUsuario(), mode);
    }
}
