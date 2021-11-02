package mil.sinte.UserServices.Programacion;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.BusinessServices.Beans.BeanPeriodoTipoAsignacion;
import mil.sinte.DataService.Service.PeriodoTipoAsignacionService;
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
public class PeriodoTipoAsignacionController {

    @Autowired
    private PeriodoTipoAsignacionService periodoTipoAsignacionService;

    @RequestMapping(value = "/PeriodoTipoAsignacion")
    public String getTipoAsignacion(String mode) {
        switch (mode) {
            case "periodoTipoAsignacion":
                return "Programacion/PeriodoTipoAsignacion";
            default:
                return "redirect:/";
        }
    }

    @RequestMapping(value = "/PeriodoTipoAsignacionDetalle")
    @ResponseBody
    public String getTipoAsignacionDetalle(String mode, String periodo) {
        switch (mode) {
            case "G":
                return new Gson().toJson(periodoTipoAsignacionService.getPeriodoTipoAsignacion(periodo));
            default:
                return "ERROR";
        }
    }

    @RequestMapping(value = "/IduPeriodoTipoAsignacion")
    @ResponseBody
    public String setPeriodoTipoAsignacion(
            @RequestParam("mode") String mode,
            @RequestParam("periodo") String periodo,
            @RequestParam("tipoAsignacion") String tipoAsignacion) {
        BeanPeriodoTipoAsignacion objBeanPeriodoTipoAsignacion = new BeanPeriodoTipoAsignacion();
        objBeanPeriodoTipoAsignacion.setPeriodo(periodo);
        objBeanPeriodoTipoAsignacion.setTipoAsignacion(tipoAsignacion);
        return "" + periodoTipoAsignacionService.guardarPeriodoTipoAsignacion(objBeanPeriodoTipoAsignacion, Utiles.getUsuario(), mode);
    }
}
