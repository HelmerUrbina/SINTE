package mil.sinte.UserServices.Programacion;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.BusinessServices.Beans.BeanProgramacionEventoFinal;
import mil.sinte.BusinessServices.Beans.BeanProgramacionEventoPrincipal;
import mil.sinte.DataService.Service.ProgramacionEventoFinalService;
import mil.sinte.DataService.Service.ProgramacionEventoPrincipalService;
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
public class ProgramacionEventoPrincipalController {

    @Autowired
    private ProgramacionEventoPrincipalService programacionEventoPrincipalService;

    @Autowired
    private ProgramacionEventoFinalService programacionEventoFinalService;

    @RequestMapping(value = "/ProgramacionEventoPrincipal")
    public String getTipoAsignacion(String mode) {
        switch (mode) {
            case "programacionEventoPrincipal":
                return "Programacion/ProgramacionEventoPrincipal";
            case "programacionEventoSecundario":
                return "Programacion/ProgramacionEventoSecundario";
            case "programacionEventoFinal":
                return "Programacion/ProgramacionEventoFinal";
            default:
                return "redirect:/";
        }
    }

    @RequestMapping(value = "/ProgramacionEventoPrincipalDetalle")
    @ResponseBody
    public String getTipoAsignacionDetalle(String mode, String periodo, Integer tipoAsignacion, Integer brigada, Integer tipoCombustible, String eventoPrincipal, Integer nivel) {
        switch (mode) {
            case "G":
                return new Gson().toJson(programacionEventoPrincipalService.getProgramacionEventoPrincipal(periodo, tipoAsignacion, brigada, tipoCombustible));
            case "GS":
                return new Gson().toJson(programacionEventoPrincipalService.getProgramacionEventosSecundarios(periodo, tipoAsignacion, brigada, tipoCombustible, eventoPrincipal, nivel));
            case "GF":
                return new Gson().toJson(programacionEventoFinalService.getProgramacionEventoFinal(periodo, tipoAsignacion, brigada, tipoCombustible, eventoPrincipal));
            default:
                return "ERROR";
        }
    }

    @RequestMapping(value = "/IduProgramacionEventoPrincipal")
    @ResponseBody
    public String setGuardarEventoPrincipal(
            @RequestParam("mode") String mode,
            @RequestParam("periodo") String periodo,
            @RequestParam("tipoAsignacion") Integer tipoAsignacion,
            @RequestParam("brigada") Integer brigada,
            @RequestParam("tipoCombustible") Integer tipoCombustible,
            @RequestParam("eventoPrincipal") String eventoPrincipal,
            @RequestParam("eventoPrincipalNombre") String eventoPrincipalNombre,
            @RequestParam("nivel") Integer nivel,
            @RequestParam("niveles") Integer niveles,
            @RequestParam("eventoFinal") String eventoFinal) {
        BeanProgramacionEventoPrincipal objBeanProgramacionEventoPrincipal = new BeanProgramacionEventoPrincipal();
        objBeanProgramacionEventoPrincipal.setPeriodo(periodo);
        objBeanProgramacionEventoPrincipal.setTipoAsignacion(tipoAsignacion);
        objBeanProgramacionEventoPrincipal.setBrigada(brigada);
        objBeanProgramacionEventoPrincipal.setTipoCombustible(tipoCombustible);
        objBeanProgramacionEventoPrincipal.setEventoPrincipal(eventoPrincipal);
        objBeanProgramacionEventoPrincipal.setEventoPrincipalNombre(eventoPrincipalNombre);
        objBeanProgramacionEventoPrincipal.setNivel(nivel);
        objBeanProgramacionEventoPrincipal.setNiveles(niveles);
        objBeanProgramacionEventoPrincipal.setIsFinal(eventoFinal);
        return "" + programacionEventoPrincipalService.guardarProgramacionEventoPrincipal(objBeanProgramacionEventoPrincipal, Utiles.getUsuario(), mode);
    }

    @RequestMapping(value = "/IduProgramacionEventoFinal")
    @ResponseBody
    public String setGuardarEventoFinal(
            @RequestParam("mode") String mode,
            @RequestParam("periodo") String periodo,
            @RequestParam("tipoAsignacion") Integer tipoAsignacion,
            @RequestParam("brigada") Integer brigada,
            @RequestParam("tipoCombustible") Integer tipoCombustible,
            @RequestParam("eventoPrincipal") String eventoPrincipal,
            @RequestParam("eventoFinal") Integer eventoFinal,
            @RequestParam("eventoFinalNombre") String eventoFinalNombre,
            @RequestParam("tipoOperacion") String tipoOperacion,
            @RequestParam("prioridad") Integer prioridad) {
        BeanProgramacionEventoFinal objBeanProgramacionEventoFinal = new BeanProgramacionEventoFinal();
        objBeanProgramacionEventoFinal.setPeriodo(periodo);
        objBeanProgramacionEventoFinal.setTipoAsignacion(tipoAsignacion);
        objBeanProgramacionEventoFinal.setBrigada(brigada);
        objBeanProgramacionEventoFinal.setTipoCombustible(tipoCombustible);
        objBeanProgramacionEventoFinal.setEventoPrincipal(eventoPrincipal);
        objBeanProgramacionEventoFinal.setEventoFinal(eventoFinal);
        objBeanProgramacionEventoFinal.setEventoFinalNombre(eventoFinalNombre);
        objBeanProgramacionEventoFinal.setPrioridad(prioridad);
        objBeanProgramacionEventoFinal.setTipoOperacion(tipoOperacion);
        return "" + programacionEventoFinalService.guardarProgramacionEventoFinal(objBeanProgramacionEventoFinal, Utiles.getUsuario(), mode);
    }

}
