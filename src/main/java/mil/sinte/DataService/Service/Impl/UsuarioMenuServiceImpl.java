package mil.sinte.DataService.Service.Impl;

import java.util.ArrayList;
import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanMenu;
import mil.sinte.BusinessServices.Beans.BeanUsuarioMenu;
import mil.sinte.BusinessServices.Beans.BeanUsuarioOpciones;
import mil.sinte.DataService.DAO.UsuarioMenuDAO;
import mil.sinte.DataService.DAO.UsuarioOpcionesDAO;
import mil.sinte.DataService.Service.UsuarioMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Service
public class UsuarioMenuServiceImpl implements UsuarioMenuService {

    @Autowired
    private UsuarioMenuDAO usuarioMenuDAO;
    
    @Autowired
    private UsuarioOpcionesDAO usuarioOpcionesDAO; 

    @Override
    public List<BeanMenu> getMenuUsuario(String usuario) {
        return usuarioMenuDAO.getMenuUsuario(usuario);
    }

    @Override
    public List<BeanMenu> getModuloUsuario(String usuario) {
        return usuarioMenuDAO.getModuloUsuario(usuario);
    }
    
    @Override
    public ArrayList getOpcionesUsuario() {
        ArrayList<String> Arreglo = new ArrayList<>();
        ArrayList<String> Filas = new ArrayList<>(); 
        try {
            List<BeanUsuarioOpciones> list = usuarioOpcionesDAO.getOpcionesUsuario();
            for(BeanUsuarioOpciones u: list){
                Filas.clear();
                String arreglo = u.getUsuario() + "+++"
                        + u.getModuloCodigo() + "+++"
                        + u.getUsuarioCreador() + "+++"
                        + u.getMenuCodigo();
                Filas.add(arreglo);
                Arreglo.add("" + Filas.toString());
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        
        return Arreglo;
    }

    @Override
    public ArrayList getOpcionesOfUsuario(String usuario) {
        ArrayList<String> Arreglo = new ArrayList<>();
        List<BeanUsuarioOpciones> list = usuarioOpcionesDAO.getOpcionesOfUsuario(usuario);
        for(BeanUsuarioOpciones u : list){
            Arreglo.add(u.getUsuario());
        }
        return Arreglo;
    }


}
