package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanUsuarioGrifo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MERCANTIL GROUP SAC
 */
@Repository
public interface UsuarioGrifoDAO extends JpaRepository<BeanUsuarioGrifo, String> {

    @Query(nativeQuery = true, value = "SELECT "
            + "VUSUARIO_CODIGO, UTIL.FUN_USUARIO(VUSUARIO_CODIGO) CPERIODO_CODIGO,"
            + "NGRIFO_CODIGO, UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO "
            + "FROM SINTE_USUARIOS_GRIFO WHERE "
            + "CPERIODO_CODIGO=?1 AND "
            + "NGRIFO_CODIGO=?2 "
            + "ORDER BY VUSUARIO_CODIGO")
    List<BeanUsuarioGrifo> findByPeriodoAndGrifo(String periodo, Integer grifo);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_USUARIOS_GRIFO(:periodo, :codigo, :grifo, :usuario, :modo)}", nativeQuery = true)
    void sp_usuarioGrifo(
            @Param("periodo") String periodo,
            @Param("codigo") String codigo,
            @Param("grifo") Integer grifo,
            @Param("usuario") String usuario,
            @Param("modo") String modo);
}
