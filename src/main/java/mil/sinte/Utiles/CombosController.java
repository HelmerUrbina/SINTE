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

    public String getCombos(String mode, String codigo, String codigo2, Integer codigo3, String codigo4, String codigo5, String codigo6) {
        switch (mode) {
            case "periodos":
                return new Gson().toJson(combosService.getPeriodos());
            case "tipoCombustible":
                return new Gson().toJson(combosService.getTipoCombustible());
            case "tipoCombustibleByAsignacionCombustible":
                return new Gson().toJson(combosService.getTipoCombustibleByAsignacionCombustible(codigo, Integer.parseInt(codigo2), String.valueOf(codigo3), Integer.parseInt(codigo4)));
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
            case "tipoVehiculo":
                return new Gson().toJson(combosService.getTipoVehiculo());
            case "claseVehiculo":
                return new Gson().toJson(combosService.getClaseVehiculo());
            case "marca":
                return new Gson().toJson(combosService.getMarca());
            case "modelo":
                return new Gson().toJson(combosService.getModelo(codigo));
            case "color":
                return new Gson().toJson(combosService.getColor());
            case "soat":
                return new Gson().toJson(combosService.getSoat());
            case "areaLaboral":
                return new Gson().toJson(combosService.getAreaLaboral());
            case "rol":
                return new Gson().toJson(combosService.getRol());
            case "vehiculosByBrigada":
                return new Gson().toJson(combosService.getVehiculosByBrigadaAndPeriodo(codigo, Utiles.checkNum(codigo2)));
            case "vehiculosByPeriodo":
                return new Gson().toJson(combosService.getVehiculosByPeriodo(codigo));
            case "vehiculosByPeriodoBrigada":
                return new Gson().toJson(combosService.getVehiculosByPeriodoBrigada(codigo, codigo3));
            case "dependenciaByBrigada":
                return new Gson().toJson(combosService.getDependenciaByBrigada(codigo));
            case "tipoCombustibleByVehiculo":
                return new Gson().toJson(combosService.getTipoCombustibleByVehiculo(codigo3));
            case "meses":
                return new Gson().toJson(combosService.getMeses());    
            case "vehiculosByAsignacionCombustible":
                return new Gson().toJson(combosService.getVehiculoByAsignacionCombustible(codigo, Integer.parseInt(codigo2), String.valueOf(codigo3), Integer.parseInt(codigo4), Integer.parseInt(codigo5),Integer.parseInt(codigo6)));        
            default:
                return "ERROR";
        }
    }
}
