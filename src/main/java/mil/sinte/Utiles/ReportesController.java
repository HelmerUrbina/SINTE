package mil.sinte.Utiles;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Controller
@Slf4j
public class ReportesController {

    private static final long serialVersionUID = 4440011247408877539L;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/Reportes")
    public void generateReport(HttpServletResponse response, String reporte, String periodo, String tipoAsignacion, String brigada, String tipoCombustible, String eventoPrincipal, String codigo) throws IOException, JRException {
        try {
            Connection objConnection = jdbcTemplate.getDataSource().getConnection();
            String nombre = "";
            switch (reporte) {
                case "PROG0001":
                    nombre = "Programacion/PROG0001.jasper";
                    break;
                case "PROG0002":
                    nombre = "Programacion/PROG0002.jasper";
                    break;
                case "PROG0003":
                    nombre = "Programacion/PROG0003.jasper";
                    break;
                default:
                    break;
            }
            InputStream stream = getClass().getResourceAsStream("/templates/Reportes/" + nombre);
            if (stream == null) {
                throw new IllegalArgumentException("No se encuentra el reporte con nombre : " + nombre);
            }
            Map parameters = new HashMap();
            parameters.put("REPORT_LOCALE", new Locale("en", "US"));
            parameters.put("PERIODO", periodo);
            parameters.put("TIPO_ASIGNACION", tipoAsignacion);
            parameters.put("BRIGADA", brigada.replace("*", "%"));
            parameters.put("TIPO_COMBUSTIBLE", tipoCombustible);
            parameters.put("EVENTO_PRINCIPAL", eventoPrincipal);
            parameters.put("CODIGO", codigo.replace("*", "%"));
            parameters.put("USUARIO", Utiles.getUsuario());
            parameters.put("SUBREPORT_DIR",  getClass().getResource("/static/").getFile());
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("application/pdf");
            JasperPrint jasperPrint = JasperFillManager.fillReport(stream, parameters, objConnection);
            try (OutputStream out = response.getOutputStream()) {
                JasperExportManager.exportReportToPdfStream(jasperPrint, out);
                out.flush();
            }
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

}
