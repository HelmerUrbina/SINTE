package mil.sinte.Utiles;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.DataService.Service.CombosService;
import mil.sinte.DataService.Service.TextoService;
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

    @Autowired
    private TextoService textoService;

    @RequestMapping(value = "/CombosAjax")
    @ResponseBody
    public String getCombos(String mode, String codigo, String codigo2, Integer codigo3, String codigo4, String codigo5, String codigo6) {
        switch (mode) {
            case "periodos":
                return new Gson().toJson(combosService.getPeriodos());
            case "tipoCombustible":
                return new Gson().toJson(combosService.getTipoCombustible());
            case "tipoOperacion":
                return new Gson().toJson(combosService.getTipoOperacion());
            case "brigadas":
                return new Gson().toJson(combosService.getBrigadas());
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
            case "fuenteFinanciamiento":
                return new Gson().toJson(combosService.getFuenteFinanciamiento());
            case "periodoTipoAsignacionPendientes":
                return new Gson().toJson(combosService.getPeriodoTipoAsignacionPendiente(codigo));
            case "tipoAsignacionByPeriodo":
                return new Gson().toJson(combosService.getTipoAsignacionByPeriodo(codigo));
            case "brigadasTechosByPeriodo":
                return new Gson().toJson(combosService.getBrigadasTechosByPeriodo(codigo));
            case "tipoAsignacionTechosByPeriodoAndBrigada":
                return new Gson().toJson(combosService.getTipoAsignacionTechosByPeriodoAndBrigada(codigo, Utiles.checkNum(codigo2)));
            case "tipoCombustibleTechosByPeriodoAndBrigadaAndTipoAsignacion":
                return new Gson().toJson(combosService.getTipoCombustibleTechosByPeriodoAndBrigadaAndTipoAsignacion(codigo, Utiles.checkNum(codigo2), codigo3));
            case "dependenciaByPeriodoAndBrigadaAndTipoCombustible":
                return new Gson().toJson(combosService.getDependenciasByPeriodoAndBrigadaAndTipoCombustible(codigo, Utiles.checkNum(codigo2), codigo3));
            case "vehiculosCNVByPeriodoAndBrigadaAndTipoCombustibleAndDependencia":
                return new Gson().toJson(combosService.getVehiculosCNVByPeriodoAndBrigadaAndTipoCombustibleAndDependencia(codigo, Utiles.checkNum(codigo2), codigo3, Utiles.checkNum(codigo4)));
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
                return new Gson().toJson(combosService.getVehiculosByPeriodoAndBrigadas(codigo, Utiles.checkNum(codigo2)));
            case "vehiculosByPeriodoAndBrigadaAndDependencia":
                return new Gson().toJson(combosService.getVehiculosByPeriodoAndBrigadasAndDependencia(codigo, Utiles.checkNum(codigo2), codigo3));
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
            case "tipoCombustibleByAsignacionCombustible":
                return new Gson().toJson(combosService.getTipoCombustibleByAsignacionCombustible(codigo, Utiles.checkNum(codigo2), String.valueOf(codigo3), Utiles.checkNum(codigo4)));
            case "vehiculosByAsignacionCombustible":
                return new Gson().toJson(combosService.getVehiculoByAsignacionCombustible(codigo, Utiles.checkNum(codigo2), String.valueOf(codigo3), Utiles.checkNum(codigo4), Utiles.checkNum(codigo5), Utiles.checkNum(codigo6)));
            case "combsutibleByVariacion":
                return new Gson().toJson(combosService.getCombsutibleByVariacion(codigo, Utiles.checkNum(codigo2), String.valueOf(codigo3), Utiles.checkNum(codigo4)));
            case "vehiculoByVariacion":
                return new Gson().toJson(combosService.getVehiculoByVariacion(codigo, Utiles.checkNum(codigo2), String.valueOf(codigo3), Utiles.checkNum(codigo4), Utiles.checkNum(codigo5), Utiles.checkNum(codigo6)));
            case "dependenciaByVariacion":
                return new Gson().toJson(combosService.getDependenciaByVariacion(codigo, Utiles.checkNum(codigo2), String.valueOf(codigo3), Utiles.checkNum(codigo4), Utiles.checkNum(codigo5)));
            case "dependenciaByComision":
                return new Gson().toJson(combosService.getDependenciaByComision(codigo, Utiles.checkNum(codigo2), String.valueOf(codigo3), Utiles.checkNum(codigo4)));
            case "vehiculoByComision":
                return new Gson().toJson(combosService.getVehiculoByComision(codigo, Utiles.checkNum(codigo2), String.valueOf(codigo3), Utiles.checkNum(codigo4), Utiles.checkNum(codigo5)));
            case "combustibleByComision":
                return new Gson().toJson(combosService.getCombustibleByComision(codigo, Utiles.checkNum(codigo2), String.valueOf(codigo3), Utiles.checkNum(codigo4), Utiles.checkNum(codigo5), Utiles.checkNum(codigo6)));
            case "grifos":
                return new Gson().toJson(combosService.getGrifos());
            case "usuarioByPeriodoAndGrifoPendiente":
                return new Gson().toJson(combosService.getUsuariosByPeriodoAndGrifoPendientes(codigo, Utiles.checkNum(codigo2)));
            default:
                return "ERROR";
        }
    }

    @RequestMapping(value = "/TextoAjax")
    @ResponseBody
    public String getTexto(String mode, String codigo, String codigo2, String codigo3, String codigo4, String codigo5, String codigo6) {
        switch (mode) {
            case "precioTechosByPeriodoAndBrigadaAndTipoAsignacionAndTipoCombustible":
                return new Gson().toJson(textoService.getPrecioTechosByPeriodoAndBrigadaAndTipoAsignacionAndTipoCombustible(codigo, Utiles.checkNum(codigo2), Utiles.checkNum(codigo3), Utiles.checkNum(codigo4)));
            case "saldoTechosByPeriodoAndBrigadaAndTipoAsignacionAndTipoCombustible":
                return new Gson().toJson(textoService.getSaldoTechosByPeriodoAndBrigadaAndTipoAsignacionAndTipoCombustible(codigo, Utiles.checkNum(codigo2), Utiles.checkNum(codigo3), Utiles.checkNum(codigo4)));
            default:
                return "ERROR";
        }
    }
}
