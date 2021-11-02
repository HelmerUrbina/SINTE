package mil.sinte.UserServices.Configuracion;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.BusinessServices.Beans.BeanTipoCombustible;
import mil.sinte.DataService.Service.TipoCombustibleService;
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
public class TipoCombustibleController {

    @Autowired
    private TipoCombustibleService tipoCombustibleService;

    @RequestMapping(value = "/TipoCombustible")
    public String getTipoCombustible(String mode) {
        switch (mode) {
            case "tipoCombustible":
                return "Configuracion/TipoCombustible";
            default:
                return "redirect:/";
        }
    }

    @RequestMapping(value = "/TipoCombustibleDetalle")
    @ResponseBody
    public String getTipoCombustibleDetalle(String mode, Integer codigo) {
        switch (mode) {
            case "G":
                return new Gson().toJson(tipoCombustibleService.getTipoCombustible());
            case "U":
                return new Gson().toJson(tipoCombustibleService.getTipoCombustible(codigo));
            default:
                return "ERROR";
        }
    }

    @RequestMapping(value = "/IduTipoCombustible")
    @ResponseBody
    public String setTipoCombustible(
            @RequestParam("mode") String mode,
            @RequestParam("codigo") Integer codigo,
            @RequestParam("abreviatura") String abreviatura,
            @RequestParam("descripcion") String descripcion) {
        BeanTipoCombustible objBeanTipoCombustible = new BeanTipoCombustible();
        objBeanTipoCombustible.setCodigo(codigo);
        objBeanTipoCombustible.setDescripcion(descripcion);
        objBeanTipoCombustible.setAbreviatura(abreviatura);
        return "" + tipoCombustibleService.guardarTipoCombustible(objBeanTipoCombustible, Utiles.getUsuario(), mode);
    }

}
