package mil.sinte.UserServices.Configuracion;

import com.google.gson.Gson;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.BusinessServices.Beans.BeanVehiculoSoat;
import mil.sinte.BusinessServices.Beans.BeanVehiculoTipoCombustible;
import mil.sinte.BusinessServices.Beans.BeanVehiculos;
import mil.sinte.DataService.Service.VehiculoService;
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
public class VehiculosController {

    @Autowired
    private VehiculoService vehiculoService;

    @RequestMapping(value = "/Vehiculos")
    public String getVehiculos(String mode) {
        switch (mode) {
            case "vehiculos":
                return "Configuracion/Vehiculos";
            default:
                return "redirect:/";
        }
    }

    @RequestMapping(value = "/VehiculoDetalle")
    @ResponseBody
    public String getVehiculoDetalle(String mode, Integer codigo) {
        switch (mode) {
            case "G":
                return new Gson().toJson(vehiculoService.getVehiculos());
            case "U":
                return new Gson().toJson(vehiculoService.getVehiculo(codigo));
            default:
                return "ERROR";
        }
    }

    @RequestMapping(value = "/IduVehiculo")
    @ResponseBody
    public String iduVehiculo(
            @RequestParam("mode") String mode,
            @RequestParam("codigo") Integer codigo,
            @RequestParam("placa") String placa,
            @RequestParam("serieChasis") String serieChasis,
            @RequestParam("serieMotor") String serieMotor,
            @RequestParam("tipoVehiculo") String tipoVehiculo,
            @RequestParam("claseVehiculo") String claseVehiculo,
            @RequestParam("marca") String marca,
            @RequestParam("modelo") String modelo,
            @RequestParam("transmision") String transmision,
            @RequestParam("fabricacion") String fabricacion,
            @RequestParam("puertas") Integer puertas,
            @RequestParam("color") String color
    ) {
        BeanVehiculos objBeanVehiculo = new BeanVehiculos();
        objBeanVehiculo.setCodigo(codigo);
        objBeanVehiculo.setPlaca(placa);
        objBeanVehiculo.setSerieChasis(serieChasis);
        objBeanVehiculo.setSerieMotor(serieMotor);
        objBeanVehiculo.setTipo(tipoVehiculo);
        objBeanVehiculo.setClase(claseVehiculo);
        objBeanVehiculo.setMarca(marca);
        objBeanVehiculo.setModelo(modelo);
        objBeanVehiculo.setTransmision(transmision);
        objBeanVehiculo.setFabricacion(fabricacion);
        objBeanVehiculo.setPuertas(puertas);
        objBeanVehiculo.setColor(color);
        return "" + vehiculoService.guardarVehiculo(objBeanVehiculo, Utiles.getUsuario(), mode);
    }

    @RequestMapping(value = "/VehiculoTipoCombustibleDetalle")
    @ResponseBody
    public String getVehiculoTipoCombustibleDetalle(String mode, Integer vehiculo, Integer codigo) {
        switch (mode) {
            case "G":
                return new Gson().toJson(vehiculoService.getVehiculoTiposCombustibles(vehiculo));
            default:
                return "ERROR";
        }
    }

    @RequestMapping(value = "/IduVehiculoTipoCombustible")
    @ResponseBody
    public String setVehiculoTipoCombustible(
            @RequestParam("mode") String mode,
            @RequestParam("vehiculo") String vehiculo,
            @RequestParam("tipoCombustible") Integer tipoCombustible,
            @RequestParam("capacidad") Double capacidad
    ) {
        BeanVehiculoTipoCombustible objBeanVehiculoTipoCombustible = new BeanVehiculoTipoCombustible();
        objBeanVehiculoTipoCombustible.setVehiculo(vehiculo);
        objBeanVehiculoTipoCombustible.setTipoCombustible(tipoCombustible);
        objBeanVehiculoTipoCombustible.setCapacidad(capacidad);
        return "" + vehiculoService.guardarVehiculoTipoCombustible(objBeanVehiculoTipoCombustible, Utiles.getUsuario(), mode);
    }

    @RequestMapping(value = "/VehiculoSoatDetalle")
    @ResponseBody
    public String getVehiculoSoatDetalle(String mode, Integer vehiculo, Integer codigo) {
        switch (mode) {
            case "G":
                return new Gson().toJson(vehiculoService.getVehiculoSoats(vehiculo));
            default:
                return "ERROR";
        }
    }

    @RequestMapping(value = "/IduVehiculoSoat")
    @ResponseBody
    public String iduVehiculoSoat(
            @RequestParam("mode") String mode,
            @RequestParam("codigo") Integer codigo,
            @RequestParam("vehiculo") Integer vehiculo,
            @RequestParam("aseguradora") String aseguradora,
            @RequestParam("tipo") String tipo,
            @RequestParam("certificado") String certificado,
            @RequestParam("inicio") String inicio,
            @RequestParam("fin") String fin
    ) throws ParseException {
        BeanVehiculoSoat objBeanVehiculoSoat = new BeanVehiculoSoat();
        objBeanVehiculoSoat.setCodigo(codigo);
        objBeanVehiculoSoat.setVehiculo("" + vehiculo);
        objBeanVehiculoSoat.setAseguradora(aseguradora);
        objBeanVehiculoSoat.setTipo(tipo);
        objBeanVehiculoSoat.setCertificado(certificado);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); //No Complaciente en Fecha
        java.util.Date fechaInicio = sdf.parse(Utiles.checkFecha(inicio));
        java.util.Date fechaFin = sdf.parse(Utiles.checkFecha(fin));
        objBeanVehiculoSoat.setInicio(new java.sql.Date(fechaInicio.getTime()));
        objBeanVehiculoSoat.setFin(new java.sql.Date(fechaFin.getTime()));
        return "" + vehiculoService.guardarVehiculoSoat(objBeanVehiculoSoat, Utiles.getUsuario(), mode);
    }
}
