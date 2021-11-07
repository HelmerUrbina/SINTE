package mil.sinte.Utiles;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.DataService.Service.CombosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Controller
@Slf4j
public class CombosController {

    @Autowired
    private CombosService combosService;

    @RequestMapping(value = "/CombosAjax")
    @ResponseBody
    public String getAreaLaboralDetalle(String mode, String codigo, String codigo2, Integer codigo3) {
        switch (mode) {
            case "periodos":
                return new Gson().toJson(combosService.getPeriodos());
            case "tipoCombustible":
                return new Gson().toJson(combosService.getTipoCombustible());
            case "divisionEjercito":
                return new Gson().toJson(combosService.getDivisionEjercito());
            case "departamentos":
                return new Gson().toJson(combosService.getDepartamentos());
            case "provincias":
                return new Gson().toJson(combosService.getProvincias(codigo));
            case "ubigeo":
                return new Gson().toJson(combosService.getUbigeo(codigo, codigo2));
            case "tipoDependencia":
                return new Gson().toJson(combosService.getTipoDependencia());
            case "periodoTipoAsignacionPendientes":
                return new Gson().toJson(combosService.getPeriodoTipoAsignacionPendiente(codigo));
            case "tipoAsignacionByPeriodo":
                return new Gson().toJson(combosService.getTipoAsignacionByPeriodo(codigo));
            case "brigadas":
                return new Gson().toJson(combosService.getBrigadas());
            case "brigadasByPeriodoTipoAsignacion":
                return new Gson().toJson(combosService.getBrigadasByPeriodoTipoAsignacion(codigo, codigo3));
            default:
                return "ERROR";
        }
    }

}
