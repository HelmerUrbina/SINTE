package mil.sinte.UserServices.Configuracion;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.BusinessServices.Beans.BeanGrifo;
import mil.sinte.BusinessServices.Beans.BeanGrifoSurtidor;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import mil.sinte.DataService.Service.GrifoService;
import mil.sinte.DataService.Service.GrifoSurtidorService;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Controller
@Slf4j
public class GrifosSurtidorController {

    @Autowired
    private GrifoService grifoService;

    @Autowired
    private GrifoSurtidorService grifoSurtidorService;

    @RequestMapping(value = "/GrifosSurtidos")
    public String getGrifos(String mode) {
        switch (mode) {
            case "grifoSurtidor":
                return "Configuracion/GrifosSurtidor";
            default:
                return "redirect:/";
        }
    }

    @RequestMapping(value = "/GrifosDetalle")
    @ResponseBody
    public String getGrifosDetalle(String mode, Integer codigo) {
        switch (mode) {
            case "G":
                return new Gson().toJson(grifoService.getGrifos());
            case "U":
                return new Gson().toJson(grifoService.getGrifo(codigo));
            default:
                return "ERROR";
        }
    }

    @RequestMapping(value = "/GrifoSurtidorDetalle")
    @ResponseBody
    public String getDependenciaDetalle(String mode, Integer grifo, Integer grifoSurtidor) {
        switch (mode) {
            case "G":
                return new Gson().toJson(grifoSurtidorService.getGrifoSurtidores(grifo));
            case "U":
                return new Gson().toJson(grifoSurtidorService.getGrifoSurtidor(grifo, grifoSurtidor));
            default:
                return "ERROR";
        }
    }

    @RequestMapping(value = "/IduGrifo")
    @ResponseBody
    public String setGrifo(
            @RequestParam("mode") String mode,
            @RequestParam("codigo") Integer codigo,
            @RequestParam("brigada") Integer brigada,
            @RequestParam("grifoNombre") String grifoNombre,
            @RequestParam("ubigeo") String ubigeo) {
        BeanGrifo objBeanGrifo = new BeanGrifo();
        objBeanGrifo.setCodigo(codigo);
        objBeanGrifo.setBrigada(brigada);
        objBeanGrifo.setGrifoNombre(grifoNombre);
        objBeanGrifo.setUbigeo(ubigeo);
        return "" + grifoService.guardarGrifo(objBeanGrifo, Utiles.getUsuario(), mode);
    }

    @RequestMapping(value = "/IduGrifoSurtidor")
    @ResponseBody
    public String setDependencia(
            @RequestParam("mode") String mode,
            @RequestParam("grifo") Integer grifo,
            @RequestParam("grifoSurtidor") Integer grifoSurtidor,
            @RequestParam("tipoCombustible") Integer tipoCombustible,
            @RequestParam("surtidor") String surtidor,
            @RequestParam("capacidad") Integer capacidad) {
        BeanGrifoSurtidor objBeanGrifoSurtidor = new BeanGrifoSurtidor();
        objBeanGrifoSurtidor.setGrifo(grifo);
        objBeanGrifoSurtidor.setGrifoSurtidor(grifoSurtidor);
        objBeanGrifoSurtidor.setTipoCombustible(tipoCombustible);
        objBeanGrifoSurtidor.setSurtidor(surtidor);
        objBeanGrifoSurtidor.setCapacidad(capacidad);
        return "" + grifoSurtidorService.guardarGrifoSurtidor(objBeanGrifoSurtidor, Utiles.getUsuario(), mode);
    }
}
