package mil.sinte.UserServices.Configuracion;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.BusinessServices.Beans.BeanBrigadas;
import mil.sinte.BusinessServices.Beans.BeanDependencia;
import mil.sinte.DataService.Service.BrigadasService;
import mil.sinte.DataService.Service.DependenciaService;
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
public class BrigadasDependenciaController {

    @Autowired
    private BrigadasService brigadasService;

    @Autowired
    private DependenciaService dependenciaService;

    @RequestMapping(value = "/BrigadasDependencias")
    public String getBrigadas(String mode) {
        switch (mode) {
            case "brigadaDependencia":
                return "Configuracion/BrigadasDependencias";
            default:
                return "redirect:/";
        }
    }

    @RequestMapping(value = "/BrigadasDetalle")
    @ResponseBody
    public String getBrigadasDetalle(String mode, Integer codigo) {
        switch (mode) {
            case "G":
                return new Gson().toJson(brigadasService.getBrigadas());
            case "U":
                return new Gson().toJson(brigadasService.getBrigada(codigo));
            default:
                return "ERROR";
        }
    }

    @RequestMapping(value = "/DependenciaDetalle")
    @ResponseBody
    public String getDependenciaDetalle(String mode, Integer brigada, Integer codigo) {
        switch (mode) {
            case "G":
                return new Gson().toJson(dependenciaService.getDependencias(brigada));
            case "U":
                return new Gson().toJson(dependenciaService.getDependencia(brigada, codigo));
            default:
                return "ERROR";
        }
    }

    @RequestMapping(value = "/IduBrigada")
    @ResponseBody
    public String setBrigada(
            @RequestParam("mode") String mode,
            @RequestParam("codigo") Integer codigo,
            @RequestParam("brigadaCodigo") String brigadaCodigo,
            @RequestParam("divisionEjercito") String divisionEjercito,
            @RequestParam("abreviatura") String abreviatura,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("ubigeo") String ubigeo) {
        BeanBrigadas objBeanBrigada = new BeanBrigadas();
        objBeanBrigada.setCodigo(codigo);
        objBeanBrigada.setBrigadaCodigo(brigadaCodigo);
        objBeanBrigada.setDivisionEjercito(divisionEjercito);
        objBeanBrigada.setDescripcion(descripcion);
        objBeanBrigada.setAbreviatura(abreviatura);
        objBeanBrigada.setUbigeo(ubigeo);
        return "" + brigadasService.guardarBrigada(objBeanBrigada, Utiles.getUsuario(), mode);
    }

    @RequestMapping(value = "/IduDependencia")
    @ResponseBody
    public String setDependencia(
            @RequestParam("mode") String mode,
            @RequestParam("codigo") Integer codigo,
            @RequestParam("brigada") Integer brigada,
            @RequestParam("tipoDependencia") String tipoDependencia,
            @RequestParam("abreviatura") String abreviatura,
            @RequestParam("descripcion") String descripcion) {
        BeanDependencia objBeanDependencia = new BeanDependencia();
        objBeanDependencia.setCodigo(codigo);
        objBeanDependencia.setBrigada(brigada);
        objBeanDependencia.setTipoDependencia(tipoDependencia);
        objBeanDependencia.setDescripcion(descripcion);
        objBeanDependencia.setAbreviatura(abreviatura);
        return "" + dependenciaService.guardarDependencia(objBeanDependencia, Utiles.getUsuario(), mode);
    }
}
