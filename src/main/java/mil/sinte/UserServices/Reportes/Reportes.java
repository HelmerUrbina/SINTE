package mil.sinte.UserServices.Reportes;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.BusinessServices.Beans.BeanReportes;
import mil.sinte.DataService.Service.ReportesService;
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
public class Reportes {

    @Autowired
    private ReportesService reportesService;

    @RequestMapping(value = "/Reportes")
    public String getReportes(String mode) {
        switch (mode) {
            case "reporte":
                return "Reportes/Reportes";
            default:
                return "redirect:/";
        }
    }

    @RequestMapping(value = "/ReportesDetalle")
    @ResponseBody
    public String getReportesDetalle(String mode, String codigo) {
        switch (mode) {
            case "G":
                return new Gson().toJson(reportesService.getReportes());
            default:
                return "ERROR";
        }
    }

    @RequestMapping(value = "/IduReportes")
    @ResponseBody
    public String iduReportes(
            @RequestParam("mode") String mode,
            @RequestParam("codigo") String codigo,
            @RequestParam("nombre") String nombre,
            @RequestParam("firmar") String firmar) {
        BeanReportes objBeanReporte = new BeanReportes();
        objBeanReporte.setCodigo(codigo);
        objBeanReporte.setNombre(nombre);
        objBeanReporte.setFirma(firmar);
        return "" + reportesService.guardarReportes(objBeanReporte, Utiles.getUsuario(), mode);
    }
}
