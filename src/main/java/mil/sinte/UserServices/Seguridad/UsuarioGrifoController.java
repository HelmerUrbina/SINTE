package mil.sinte.UserServices.Seguridad;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.BusinessServices.Beans.BeanUsuarioGrifo;
import mil.sinte.Utiles.Utiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import mil.sinte.DataService.Service.UsuarioGrifoService;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Controller
@Slf4j
public class UsuarioGrifoController {

    @Autowired
    private UsuarioGrifoService usuarioGrifoService;

    @RequestMapping(value = "/UsuarioGrifo")
    public String getGrifosUsuario(String mode) {
        switch (mode) {
            case "usuarioGrifo":
                return "Seguridad/UsuarioGrifo";
            default:
                return "redirect:/";
        }
    }

    @RequestMapping(value = "/usuarioGrifoDetalle")
    @ResponseBody
    public String getUsuarioGrifoDetalle(String mode, String periodo, Integer grifo) {
        switch (mode) {
            case "G":
                return new Gson().toJson(usuarioGrifoService.getUsuariosGrifo(periodo, grifo));
            default:
                return "ERROR";
        }
    }

    @RequestMapping(value = "/IduUsuarioGrifo")
    @ResponseBody
    public String setUsuarioGrifo(
            @RequestParam("mode") String mode,
            @RequestParam("periodo") String periodo,
            @RequestParam("grifo") String grifo,
            @RequestParam("usuario") String usuario) {
        BeanUsuarioGrifo objBnUsuarioGrifo = new BeanUsuarioGrifo();
        objBnUsuarioGrifo.setPeriodo(periodo);
        objBnUsuarioGrifo.setGrifo(grifo);
        objBnUsuarioGrifo.setUsuario(usuario);
        return "" + usuarioGrifoService.guardarUsuariosGrifo(objBnUsuarioGrifo, Utiles.getUsuario(), mode);
    }
}
