package mil.sinte.UserServices.Configuracion;

import com.google.gson.Gson;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.BusinessServices.Beans.BeanVehiculosBrigada;
import mil.sinte.DataService.Service.VehiculosBrigadasService;
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
public class VehiculosBrigadaController {

    @Autowired
    private VehiculosBrigadasService vehiculosBrigadasService;

    @RequestMapping(value = "/VehiculosBrigada")
    public String getVehiculosBrigada(String mode) {
        switch (mode) {
            case "vehiculosBrigada":
                return "Configuracion/VehiculosBrigada";
            default:
                return "redirect:/";
        }
    }

    @RequestMapping(value = "/VehiculosBrigadaDetalle")
    @ResponseBody
    public String getVehiculosBrigadaDetalle(String mode, Integer brigada, String periodo) {
        switch (mode) {
            case "G":
                return new Gson().toJson(vehiculosBrigadasService.getVehiculosBrigadas(periodo, brigada));
            default:
                return "ERROR";
        }
    }

    @RequestMapping(value = "/IduVehiculosBrigada")
    @ResponseBody
    public String setVehiculosBrigada(
            @RequestParam("periodo") String periodo,
            @RequestParam("brigada") String brigada,
            @RequestParam("dependencia") Integer dependencia,
            @RequestParam("vehiculo") Integer vehiculo,
            @RequestParam("fecha") String fecha,
            @RequestParam("mode") String mode
    ) throws ParseException {
        BeanVehiculosBrigada objBeanVehiculosBrigada = new BeanVehiculosBrigada();
        objBeanVehiculosBrigada.setPeriodo(periodo);
        objBeanVehiculosBrigada.setBrigada(brigada);
        objBeanVehiculosBrigada.setDependencia(dependencia);
        objBeanVehiculosBrigada.setVehiculo(vehiculo);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); //No Complaciente en Fecha
        java.util.Date dfecha = sdf.parse(Utiles.checkFecha(fecha));
        objBeanVehiculosBrigada.setFecha(new java.sql.Date(dfecha.getTime()));
        return "" + vehiculosBrigadasService.guardarVehiculosBrigada(objBeanVehiculosBrigada, Utiles.getUsuario(), mode);
    }

}
