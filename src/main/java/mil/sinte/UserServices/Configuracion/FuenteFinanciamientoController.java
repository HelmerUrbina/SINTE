package mil.sinte.UserServices.Configuracion;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.DataService.Service.FuenteFinanciamientoService;
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
public class FuenteFinanciamientoController {

    @Autowired
    private FuenteFinanciamientoService fuenteFinanciamientoService;

    @RequestMapping(value = "/FuenteFinanciamiento")
    public String getFuenteFinanciamiento(String mode) {
        switch (mode) {
            case "fuenteFinanciamiento":
                return "Configuracion/FuenteFinanciamiento";
            default:
                return "redirect:/";
        }
    }

    @RequestMapping(value = "/FuenteFinanciamientoDetalle")
    @ResponseBody
    public String getFuenteFinanciamientoDetalle(String mode, String codigo) {
        switch (mode) {
            case "G":
                return new Gson().toJson(fuenteFinanciamientoService.getFuenteFinanciamiento());
            default:
                return "ERROR";
        }
    }

}
