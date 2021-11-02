package mil.sinte.UserServices.Login;

import java.util.List;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import mil.sinte.BusinessServices.Beans.BeanUsuario;
import mil.sinte.DataService.Service.UsuarioMenuService;
import mil.sinte.DataService.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Controller
@Slf4j
public class VerificaUsuario {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioMenuService usuarioMenuService;

    @GetMapping("/")
    public String verificaUsuario(Model model, @AuthenticationPrincipal User user, HttpSession session) {
        BeanUsuario usuario = usuarioService.findByUsernameAndEstado(user.getUsername(), "AC");
        if (usuario != null) {
            if (session.getAttribute("usuario") == null) {
                usuario.setPassword(null);
                session.setAttribute("usuario", usuario);
            }
            session.setAttribute("objModulos", usuarioMenuService.getModuloUsuario(user.getUsername()));
            session.setAttribute("objMenus", usuarioMenuService.getMenuUsuario(user.getUsername()));
            log.info("usuario que hizo login : " + user);
            return "Login/Principal";
        } else {
            return "/login?logout";
        }
    }

    @GetMapping("/FinalizaSesion")
    public String principal(Model model) {
        return "/login?logout";
    }

}
