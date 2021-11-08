
package mil.sinte.UserServices.Configuracion;


/**
 *
 * @author MERCANTIL GROUP SAC
 */
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.BusinessServices.Beans.BeanAreaLaboral;
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


@Controller
@Slf4j
public class VehiculoController {
    
    @Autowired
    private VehiculoService vehiculoService;
    
    @RequestMapping(value = "/Vehiculo")
    public String getVehiculo(String mode) {
        switch (mode) {
            case "vehiculo":
                return "Configuracion/Vehiculo";
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
    public String setVehiculo(
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
            case "U":
                return new Gson().toJson(vehiculoService.getVehiculoTipoCombustible(vehiculo, codigo));
            default:
                return "ERROR";
        }
    }
    
    @RequestMapping(value = "/IduVehiculoTipoCombustible")
    @ResponseBody
    public String setVehiculoTipoCombustible(
            @RequestParam("mode") String mode,
            @RequestParam("vehiculo") String vehiculo,
            @RequestParam("tipoCombustible") String tipoCombustible,
            @RequestParam("capacidad") double capacidad
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
            case "U":
                return new Gson().toJson(vehiculoService.getVehiculoSoat(vehiculo, codigo));
            default:
                return "ERROR";
        }
    }
    
    @RequestMapping(value = "/IduVehiculoSoat")
    @ResponseBody
    public String setVehiculoSoat(
            @RequestParam("mode") String mode,
            @RequestParam("codigo") Integer codigo,
            @RequestParam("vehiculo") String vehiculo,
            @RequestParam("soat") String soat,
            @RequestParam("certificado") String certificado,
            @RequestParam("inicio") String inicio,
            @RequestParam("fin") String fin,
            @RequestParam("tipo") String tipo
            ) {
        BeanVehiculoSoat objBeanVehiculoSoat = new BeanVehiculoSoat();
        objBeanVehiculoSoat.setCodigo(codigo);
        objBeanVehiculoSoat.setVehiculo(vehiculo);
        objBeanVehiculoSoat.setSoat(soat);
        objBeanVehiculoSoat.setCertificado(certificado);
        objBeanVehiculoSoat.setInicio(inicio);
        objBeanVehiculoSoat.setFin(fin);
        objBeanVehiculoSoat.setTipo(tipo);
        
        return "" + vehiculoService.guardarVehiculoSoat(objBeanVehiculoSoat, Utiles.getUsuario(), mode);
    }
}
