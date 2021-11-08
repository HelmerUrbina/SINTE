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
    
    @Query(nativeQuery = true, value =  "SELECT VUSUARIO_CODIGO, '' VUSUARIO_PASSWORD, \n" +
                                        "       UTIL.FUN_BRIGADAS(NAREA_LABORAL_CODIGO) NAREA_LABORAL_CODIGO,\n" +
                                        "       UTIL.FUN_USUARIOS_ROLES(NUSUARIO_ROL_CODIGO) NUSUARIO_ROL_CODIGO,\n" +
                                        "       UTIL.FUN_BRIGADAS(NBRIGADA_CODIGO) NBRIGADA_CODIGO,\n" +
                                        "       VUSUARIO_PATERNO,\n" +
                                        "       VUSUARIO_MATERNO,\n" +
                                        "       VUSUARIO_NOMBRES,\n" +
                                        "       VUSUARIO_CORREO,\n" +
                                        "       VUSUARIO_TELEFONO,\n" +
                                        "       VUSUARIO_CARGO,\n" +
                                        "       NUSUARIO_AUTORIZACION,\n" +
                                        "       UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO\n" +
                                        "  FROM SINTE_USUARIOS \n"+
                                        " ORDER BY VUSUARIO_CODIGO")
    @Override
    public List<BeanUsuario> findAll();
    
    @Query(nativeQuery = true, value =  "SELECT VUSUARIO_CODIGO, '' VUSUARIO_PASSWORD, \n" +
                                        "       NAREA_LABORAL_CODIGO,\n" +
                                        "       NUSUARIO_ROL_CODIGO,\n" +
                                        "       NBRIGADA_CODIGO,\n" +
                                        "       VUSUARIO_PATERNO,\n" +
                                        "       VUSUARIO_MATERNO,\n" +
                                        "       VUSUARIO_NOMBRES,\n" +
                                        "       VUSUARIO_CORREO,\n" +
                                        "       VUSUARIO_TELEFONO,\n" +
                                        "       VUSUARIO_CARGO,\n" +
                                        "       NUSUARIO_AUTORIZACION,\n" +
                                        "       UTIL.FUN_ESTADO_DESCRIPCION(CESTADO_CODIGO) CESTADO_CODIGO\n" +
                                        "  FROM SINTE_USUARIOS\n" +
                                        " WHERE VUSUARIO_CODIGO =?1")
    public BeanUsuario findByCodigo(String codigo);
    
    @Transactional
    @Modifying
    @Query(value = "{CALL SP_IDU_USUARIO(:codigo, :areaLaboral, :rol, :brigada, :paterno, :materno, :nombres, :correo, :telf, :cargo, :autorizacion, :usuario, :modo)}", nativeQuery = true)
    void sp_usuario(
            @Param("codigo") String codigo,
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
            @Param("usuario") String usuario,
            @Param("modo") String modo);

}
