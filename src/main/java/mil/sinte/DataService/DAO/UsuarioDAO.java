package mil.sinte.DataService.DAO;

import java.util.List;
import mil.sinte.BusinessServices.Beans.BeanUsuario;
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
public interface UsuarioDAO extends JpaRepository<BeanUsuario, String> {

    BeanUsuario findByUsuario(String usuario);

    BeanUsuario findByUsuarioAndEstado(String usuario, String estado);

    @Query(nativeQuery = true, value = "SELECT VUSUARIO_CODIGO, '' VUSUARIO_PASSWORD, "
            + "UTIL.FUN_AREA_LABORAL(NAREA_LABORAL_CODIGO) NAREA_LABORAL_CODIGO, "
            + "UTIL.FUN_USUARIOS_ROLES(NUSUARIO_ROL_CODIGO) NUSUARIO_ROL_CODIGO, "
            + "UTIL.FUN_BRIGADA_ABREVIATURA(NBRIGADA_CODIGO) NBRIGADA_CODIGO, "
            + "VUSUARIO_PATERNO, VUSUARIO_MATERNO, VUSUARIO_NOMBRES, VUSUARIO_CORREO, "
            + "VUSUARIO_TELEFONO, VUSUARIO_CARGO, NUSUARIO_AUTORIZACION, "
            + "UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO "
            + "FROM SINTE_USUARIOS "
            + "ORDER BY VUSUARIO_CODIGO")
    @Override
    public List<BeanUsuario> findAll();

    @Query(nativeQuery = true, value = "SELECT VUSUARIO_CODIGO, "
            + "'' VUSUARIO_PASSWORD, NAREA_LABORAL_CODIGO, NUSUARIO_ROL_CODIGO, NBRIGADA_CODIGO, "
            + "VUSUARIO_PATERNO, VUSUARIO_MATERNO, VUSUARIO_NOMBRES, VUSUARIO_CORREO, "
            + "VUSUARIO_TELEFONO, VUSUARIO_CARGO, NUSUARIO_AUTORIZACION, "
            + "UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO "
            + "FROM SINTE_USUARIOS WHERE "
            + "VUSUARIO_CODIGO =?1")
    public BeanUsuario findByCodigo(String codigo);

    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_USUARIO(:codigo, :password, :areaLaboral, :rol, :brigada, :paterno, :materno, :nombres, :correo, :telf, :cargo, :autorizacion, :opciones, :usuario, :modo)}", nativeQuery = true)
    void sp_usuario(
            @Param("codigo") String codigo,
            @Param("password") String password,
            @Param("areaLaboral") int areaLaboral,
            @Param("rol") int rol,
            @Param("brigada") int brigada,
            @Param("paterno") String paterno,
            @Param("materno") String materno,
            @Param("nombres") String nombres,
            @Param("correo") String correo,
            @Param("telf") String telf,
            @Param("cargo") String cargo,
            @Param("autorizacion") int autorizacion,
            @Param("opciones") String opciones,
            @Param("usuario") String usuario,
            @Param("modo") String modo);

}
