package mil.sinte.UserServices.Programacion;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.BusinessServices.Beans.BeanProgramacionClaseIIITechos;
import mil.sinte.DataService.Service.ProgramacionClaseIIITechosService;
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
public class ProgramacionClaseIIITechosController {

    @Autowired
    private ProgramacionClaseIIITechosService programacionClaseIIIService;

    @RequestMapping(value = "/ProgramacionClaseIIITechos")
    public String getTipoAsignacion(String mode) {
        switch (mode) {
            case "programacionClaseIIITechos":
                return "Programacion/ProgramacionClaseIIITechos";
            default:
                return "redirect:/";
        }
    }

    @RequestMapping(value = "/ProgramacionClaseIIITechosDetalle")
    @ResponseBody
    public String getTipoAsignacionDetalle(String mode, String periodo, String tipoAsignacion) {
        switch (mode) {
            case "G":
                return new Gson().toJson(programacionClaseIIIService.getProgramacionClaseIIITechos(periodo, tipoAsignacion));
            default:
                return "ERROR";
        }
    }

    @RequestMapping(value = "/IduProgramacionClaseIIITechos")
    @ResponseBody
    public String setPeriodoTipoAsignacion(
            @RequestParam("mode") String mode,
            @RequestParam("periodo") String periodo,
            @RequestParam("tipoAsignacion") Integer tipoAsignacion,
            @RequestParam("brigada") Integer brigada,
            @RequestParam("importe") Double importe) {
        BeanProgramacionClaseIIITechos objBeanProgramacionClaseIII = new BeanProgramacionClaseIIITechos();
        objBeanProgramacionClaseIII.setPeriodo(periodo);
        objBeanProgramacionClaseIII.setTipoAsignacion(tipoAsignacion);
        objBeanProgramacionClaseIII.setBrigada(brigada);
        objBeanProgramacionClaseIII.setImporte(importe);
        System.out.println(tipoAsignacion+" "+brigada+" "+importe);
        return "" + programacionClaseIIIService.guardarProgramacionClaseIIITechos(objBeanProgramacionClaseIII, Utiles.getUsuario(), mode);
    }
}
