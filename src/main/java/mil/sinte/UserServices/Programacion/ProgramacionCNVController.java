package mil.sinte.UserServices.Programacion;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.BusinessServices.Beans.BeanProgramacionCNV;
import mil.sinte.DataService.Service.ProgramacionCNVService;
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
public class ProgramacionCNVController {

    @Autowired
    private ProgramacionCNVService programacionCNVService;

    @RequestMapping(value = "/ProgramacionCNV")
    public String getTipoAsignacion(String mode) {
        switch (mode) {
            case "programacionCNV":
                return "Programacion/ProgramacionCNV";
            default:
                return "redirect:/";
        }
    }

    @RequestMapping(value = "/ProgramacionCNVDetalle")
    @ResponseBody
    public String getTipoAsignacionDetalle(String mode, String periodo, Integer tipoAsignacion, Integer brigada, String eventoPrincipal, Integer eventoFinal) {
        switch (mode) {
            case "G":
                return new Gson().toJson(programacionCNVService.getProgramacionCNV(periodo, tipoAsignacion, brigada, eventoPrincipal, eventoFinal));
            default:
                return "ERROR";
        }
    }

    @RequestMapping(value = "/IduProgramacionCNV")
    @ResponseBody
    public String setGuardarCNV(
            @RequestParam("mode") String mode,
            @RequestParam("periodo") String periodo,
            @RequestParam("tipoAsignacion") Integer tipoAsignacion,
            @RequestParam("brigada") Integer brigada,
            @RequestParam("eventoPrincipal") String eventoPrincipal,
            @RequestParam("eventoFinal") Integer eventoFinal,
            @RequestParam("codigo") String codigo,
            @RequestParam("dependencia") String dependencia,
            @RequestParam("vehiculo") String vehiculo,
            @RequestParam("tipoCombustible") String tipoCombustible,
            @RequestParam("precio") Double precio,
            @RequestParam("cantidad") Double cantidad,
            @RequestParam("demandaGlobal") Double demandaGlobal) {
        BeanProgramacionCNV objBeanProgramacionCNV = new BeanProgramacionCNV();
        objBeanProgramacionCNV.setPeriodo(periodo);
        objBeanProgramacionCNV.setTipoAsignacion(tipoAsignacion);
        objBeanProgramacionCNV.setBrigada(brigada);
        objBeanProgramacionCNV.setEventoPrincipal(eventoPrincipal);
        objBeanProgramacionCNV.setEventoFinal(eventoFinal);
        objBeanProgramacionCNV.setCodigo(codigo);
        objBeanProgramacionCNV.setDependencia(dependencia);
        objBeanProgramacionCNV.setVehiculo(vehiculo);
        objBeanProgramacionCNV.setTipoCombustible(tipoCombustible);
        objBeanProgramacionCNV.setPrecio(precio);
        objBeanProgramacionCNV.setCantidad(cantidad);
        objBeanProgramacionCNV.setDemandaGlobal(demandaGlobal);
        return "" + programacionCNVService.guardarProgramacionCNV(objBeanProgramacionCNV, Utiles.getUsuario(), mode);
    }

}
