package mil.sinte.UserServices.ClaseIII;

import com.google.gson.Gson;
import java.text.ParseException;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.BusinessServices.Beans.BeanOrdenPedido;
import mil.sinte.DataService.Service.OrdenPedidoService;
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
public class OrdenPedidoController {

    @Autowired
    private OrdenPedidoService ordenPedidoService;

    @RequestMapping(value = "/OrdenPedido")
    public String getOrdenPedido(String mode) {
        switch (mode) {
            case "ordenPedido":
                return "ClaseIII/OrdenPedido";
            default:
                return "redirect:/";
        }
    }

    @RequestMapping(value = "/OrdenPedidoDetalle")
    @ResponseBody
    public String getOrdenPedidoDetalle(String mode, String periodo, String mes, Integer codigo) {
        switch (mode) {
            case "G":
                return new Gson().toJson(ordenPedidoService.getListaOrdenPedidos(periodo, mes));
            case "U":
                return new Gson().toJson(ordenPedidoService.getOrdenPedido(periodo, codigo));
            case "GD":
                return new Gson().toJson(ordenPedidoService.getListaOrdenPedidoDetalle(periodo, codigo));
            default:
                return "ERROR";
        }
    }

    @RequestMapping(value = "/IduOrdenPedido")
    @ResponseBody
    public String iduAreaLaboral(
            @RequestParam("mode") String mode,
            @RequestParam("periodo") String periodo,
            @RequestParam("ordenPedido") Integer ordenPedido,
            @RequestParam("tipoAsignacion") String tipoAsignacion,
            @RequestParam("fuenteFinanciamiento") String fuenteFinanciamiento,
            @RequestParam("fecha") String fecha,
            @RequestParam("grifo") String grifo,
            @RequestParam("lista") String lista) throws ParseException {
        BeanOrdenPedido objBeanOrdenPedido = new BeanOrdenPedido();
        objBeanOrdenPedido.setPeriodo(periodo);
        objBeanOrdenPedido.setOrdenPedido(ordenPedido);
        objBeanOrdenPedido.setTipoAsignacion(tipoAsignacion);
        objBeanOrdenPedido.setFuenteFinanciamiento(fuenteFinanciamiento);
        objBeanOrdenPedido.setFecha(fecha);
        objBeanOrdenPedido.setGrifo(grifo);
        objBeanOrdenPedido.setEstado(lista);
        return "" + ordenPedidoService.guardarOrdenPedido(objBeanOrdenPedido, Utiles.getUsuario(), mode);
    }
}
