package mil.sinte.Utiles;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.Part;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
public class Utiles {

    public static String checkStr(String dato) {
        if (dato == null) {
            return "";
        }
        return dato;
    }

    public static Integer checkNum(String dato) {
        if (dato == null) {
            return 0;
        }
        if (dato.equals("")) {
            return 0;
        }
        dato = dato.replace((char) 127, (char) 48);
        return Integer.valueOf(dato.trim());
    }

    public static String CompletarCeros(String dato, int tamaño) {
        for (int i = tamaño; i > dato.length(); i--) {
            dato = '0' + dato;
        }
        return dato;
    }

    public static double checkDouble(String dato) {
        if (dato == null) {
            return 0.00;
        }
        if (dato.equals("")) {
            return 0.00;
        }
        return Double.parseDouble(dato);
    }

    public static String checkFecha(String dato) {
        if (dato == "" || dato == null) {
            return fechaServidor();
        }
        return dato;
    }

    public static String fechaServidor() {
        java.util.Date fechaSistema = new java.util.Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(fechaSistema);
    }

    public static String[][] generaLista(String cadena, int tamaño) {
        String[][] matriz;
        String datos;
        cadena = cadena.replace("[", "");
        cadena = cadena.replace("]", "");
        List<String> vector = new ArrayList<>(Arrays.asList(cadena.split("\",\"")));
        matriz = new String[vector.size()][tamaño];
        for (int i = 0; i < vector.size(); i++) {
            datos = vector.get(i);
            datos = datos.replace((char) 34, (char) 0);
            List<String> arreglo = new ArrayList<>(Arrays.asList(datos.split("---")));
            for (int j = 0; j < tamaño; j++) {
                matriz[i][j] = arreglo.get(j);
            }
        }
        return matriz;
    }

    public static Boolean checkBoolean(String dato) {
        if (dato == null) {
            return false;
        }
        return dato.equals("true");
    }

    public static String getFileName(Part part) {
        String contentHeader = part.getHeader("content-disposition");
        String[] subHeaders = contentHeader.split(";");
        for (String current : subHeaders) {
            if (current.trim().startsWith("filename")) {
                int pos = current.indexOf('=');
                String fileName = current.substring(pos + 1);
                return fileName.replace("\"", "");
            }
        }
        return null;
    }

    public static String encriptarPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public static String getUsuario() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        return userDetails.getUsername();
    }

    public static String getErrorSQL(Exception e) {
        String msj = null;
        if(e !=null){
            msj = e.getCause().getCause().getLocalizedMessage();
        }
        return "<span style='color: white;'>" + msj + "</span>";
    }

}
