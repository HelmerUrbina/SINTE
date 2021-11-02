package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanCombos;
import mil.sinte.BusinessServices.Beans.BeanMenu;
import mil.sinte.BusinessServices.Beans.BeanUsuarioMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Repository
public interface UsuarioMenuDAO extends JpaRepository<BeanUsuarioMenu, String> {

    @Query(nativeQuery = true, value = "SELECT "
            + "ME.NMODULO_CODIGO AS MODULO, ME.NMENU_CODIGO AS MENU, ME.VMENU_NOMBRE AS NOMBRE, "
            + "ME.VMENU_SERVLET AS SERVLET, ME.VMENU_MODO AS MODO "
            + "FROM SINTE_MENU ME, SINTE_USUARIOS_MENU U WHERE "
            + "U.NMODULO_CODIGO=ME.NMODULO_CODIGO AND "
            + "U.NMENU_CODIGO=ME.NMENU_CODIGO AND "
            + "U.VUSUARIO_CODIGO=?1 "
            + "ORDER BY MODULO, MENU ")
    List<BeanMenu> getMenuUsuario(String usuario);

    @Query(nativeQuery = true, value = "SELECT DISTINCT "
            + "MODU.NMODULO_CODIGO AS MODULO, MODU.VMODULO_NOMBRE AS NOMBRE "
            + "FROM SINTE_USUARIOS_MENU MENU INNER JOIN SINTE_MODULOS MODU ON ("
            + "MENU.NMODULO_CODIGO=MODU.NMODULO_CODIGO) WHERE "
            + "MENU.VUSUARIO_CODIGO=?1 "
            + "ORDER BY MODULO")
    List<BeanMenu> getModuloUsuario(String usuario);

}
